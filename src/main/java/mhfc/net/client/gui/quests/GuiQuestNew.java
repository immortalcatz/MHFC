package mhfc.net.client.gui.quests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.vecmath.Vector2f;

import mhfc.net.client.gui.ClickableGuiList;
import mhfc.net.client.gui.ClickableGuiList.GuiListStringItem;
import mhfc.net.client.gui.IMHFCGuiItem;
import mhfc.net.client.gui.IMHFCTab;
import mhfc.net.client.gui.MHFCGui;
import mhfc.net.client.quests.MHFCRegQuestVisual;
import mhfc.net.client.quests.api.IVisualDefinition;
import mhfc.net.client.util.gui.MHFCGuiUtil;
import mhfc.net.common.network.PacketPipeline;
import mhfc.net.common.network.message.quest.MessageMHFCInteraction;
import mhfc.net.common.network.message.quest.MessageMHFCInteraction.Interaction;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.inventory.Slot;
import net.minecraft.util.ResourceLocation;

public class GuiQuestNew extends MHFCGui implements IMHFCTab {

	private static final int buttonHeight = 20;
	private static final int yBorder = 15;
	private int questsW = 70, questsX = 15;
	// private List<String> groupIDsDisplayed;
	private ClickableGuiList<GuiListStringItem> groupList;
	private GuiButton newQuest, left, right;
	private List<ResourceLocation> questIdentifiers;
	private int selectedIdentifier;
	private int xSize, ySize;
	private int page = 0;

	public GuiQuestNew(Collection<String> groupIDs) {
		// groupIDsDisplayed = new ArrayList<String>(groupIDs);
		questIdentifiers = new ArrayList<>();
		groupList = new ClickableGuiList<>(width, height);
		for (String groupID : groupIDs) {
			groupList.add(new GuiListStringItem(groupID));
		}
		addScreenComponent(groupList, new Vector2f(questsX, yBorder + 10));
		newQuest = new GuiButton(0, 25, 10, 60, 20, "Take Quest") {
			@Override
			public boolean mousePressed(Minecraft p_146116_1_, int p_146116_2_, int p_146116_3_) {
				if (super.mousePressed(p_146116_1_, p_146116_2_, p_146116_3_)) {
					if (selectedIdentifier >= 0 && selectedIdentifier < questIdentifiers.size()) {
						ResourceLocation questID = questIdentifiers.get(selectedIdentifier);
						PacketPipeline.networkPipe
								.sendToServer(new MessageMHFCInteraction(Interaction.NEW_QUEST, questID.toString()));
					}
					return true;
				}
				return false;
			}
		};
		left = new GuiButton(1, 10, 10, 20, 20, "<") {
			@Override
			public boolean mousePressed(Minecraft p_146116_1_, int p_146116_2_, int p_146116_3_) {
				if (super.mousePressed(p_146116_1_, p_146116_2_, p_146116_3_)) {
					setIdentifier(selectedIdentifier - 1);
					return true;
				}
				return false;
			}
		};
		right = new GuiButton(2, 10, 10, 20, 20, ">") {
			@Override
			public boolean mousePressed(Minecraft p_146116_1_, int p_146116_2_, int p_146116_3_) {
				if (super.mousePressed(p_146116_1_, p_146116_2_, p_146116_3_)) {
					setIdentifier(selectedIdentifier + 1);
					return true;
				}
				return false;
			}
		};

		this.width = 374;
		this.height = 220;
		this.xSize = 374;
		this.ySize = 220;
	}

	protected void setIdentifier(int i) {
		selectedIdentifier = Math.max(Math.min(questIdentifiers.size() - 1, i), 0);
	}

	@Override
	public void onGuiClosed() {
		super.onGuiClosed();
	}

	@Override
	public void initGui() {
		buttonList.add(newQuest);
		buttonList.add(left);
		buttonList.add(right);
		updateScreen();
		super.initGui();
	}

	@Override
	public void updateTab() {
		getPosition(groupList).set(questsX, yBorder + 10);
		groupList.setWidthAndHeight(questsW, ySize - 2 * yBorder - 10);
		right.xPosition = xSize - questsX - right.getButtonWidth();
		right.yPosition = yBorder;
		left.xPosition = questsX + questsW + 5;
		left.yPosition = yBorder;
		newQuest.xPosition = (xSize - questsX - questsW - newQuest.getButtonWidth()) / 2 + questsX + questsW;
		newQuest.yPosition = ySize - yBorder - buttonHeight;
		left.visible = true;
		right.visible = true;
		newQuest.visible = true;
		left.enabled = selectedIdentifier > 0;
		right.enabled = questIdentifiers != null && selectedIdentifier < questIdentifiers.size() - 1;
	}

	@Override
	public void updateScreen() {
		updateTab();
		super.updateScreen();
	}

	@Override
	public boolean doesGuiPauseGame() {
		return false;
	}

	@Override
	public void drawBackground(int p_146278_1_) {
		mc.getTextureManager().bindTexture(MHFCRegQuestVisual.QUEST_BOARD_BACKGROUND);
		MHFCGuiUtil.drawTexturedBoxFromBorder(0, 0, this.zLevel, this.xSize, this.ySize, 0, 0, 1f, 1f);
	}

	@Override
	public void draw(double mousePosX, double mousePosY, float partialTick) {
		updateScreen();
		drawBackground(0);
		// TODO unlocalize
		fontRenderer.drawString("Take a quest: ", 8, yBorder, MHFCGuiUtil.COLOUR_TEXT);
		super.draw(mousePosX, mousePosY, partialTick);
		if (questIdentifiers == null || selectedIdentifier < 0 || selectedIdentifier >= questIdentifiers.size()) {
			newQuest.enabled = false;
		} else {
			ResourceLocation selectedQuestID = questIdentifiers.get(selectedIdentifier);
			IVisualDefinition visualInfo = MHFCRegQuestVisual.getQuestInformation(selectedQuestID);
			newQuest.enabled = true;
			// TODO set start enabled based on can join
			if (visualInfo == null) {
				return;
			}
			int pageCount = visualInfo.getPageCount();
			visualInfo.drawInformation(
					questsX + questsW,
					yBorder,
					xSize - 2 * questsX - questsW,
					ySize - 30,
					page % pageCount,
					fontRenderer);
		}
	}

	@Override
	public boolean handleClick(float mouseX, float mouseY, int mouseButton) throws IOException {
		if (super.handleClick(mouseX, mouseY, mouseButton)) {
			return true;
		}
		boolean shouldDisplayInfo = questIdentifiers.size() > 0 && !MHFCRegQuestVisual.hasPlayerQuest();
		boolean clickInArea = mouseX > 80 && mouseX < 300 && mouseY > 0 && mouseY < ySize - 30;
		if (!shouldDisplayInfo || !clickInArea) {
			return false;
		}
		int add = mouseButton == 0 ? 1 : mouseButton == 1 ? -1 : 0;
		page += add;
		page = (page + 3) % 3;
		return true;
	}

	@Override
	public boolean containsSlot(Slot slot) {
		return false;
	}

	@Override
	public void onClose() {}

	@Override
	public void onOpen() {}

	@Override
	protected void itemUpdated(IMHFCGuiItem guiItem) {
		if (guiItem == groupList) {
			GuiListStringItem item = groupList.getSelectedItem();
			String selectedList = item == null ? "" : item.getInitializationString();
			questIdentifiers.clear();
			Set<ResourceLocation> newQuestIDs = MHFCRegQuestVisual.getAvailableQuestIDs(selectedList);
			questIdentifiers.addAll(newQuestIDs);
		}
	}
}
