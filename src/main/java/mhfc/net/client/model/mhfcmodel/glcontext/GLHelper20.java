package mhfc.net.client.model.mhfcmodel.glcontext;

import static org.lwjgl.opengl.GL11.glGetInteger;
import static org.lwjgl.opengl.GL20.GL_CURRENT_PROGRAM;
import static org.lwjgl.opengl.GL20.GL_VERTEX_SHADER;
import static org.lwjgl.opengl.GL20.glAttachShader;
import static org.lwjgl.opengl.GL20.glDeleteShader;
import static org.lwjgl.opengl.GL20.glDetachShader;
import static org.lwjgl.opengl.GL20.glUseProgram;
import mhfc.net.client.model.mhfcmodel.AnimationInformation;
import mhfc.net.client.model.mhfcmodel.MHFCAttack;
import mhfc.net.client.model.mhfcmodel.data.ModelData20;
import mhfc.net.client.model.mhfcmodel.data.RawModelData;
import mhfc.net.common.entity.type.IMHFCAnimatedEntity;

public class GLHelper20 implements IGLHelper<ModelData20> {
	private static boolean initiated = false;
	private static int shaderName;
	private static int programName;
	private static int proxyProgram;

	private static void init() {
		try {
			if (shaderName == 0)
				shaderName = GLStatics.compileShaderSafe(GL_VERTEX_SHADER,
						GLHelper20.class.getResourceAsStream("default20.vsh"));
			if (programName == 0)
				programName = GLStatics.createProgramSafe();
			if (proxyProgram == 0)
				proxyProgram = GLStatics.createProgramSafe();
			glAttachShader(programName, shaderName);
			GLStatics.linkProgramSafe(programName);
			glDeleteShader(shaderName); // Can now do this, shader always linked
										// to programName
		} catch (Exception e) {
			throw new IllegalStateException(
					"Error setting up OpenGL enviroment.", e);
		}
		initiated = true;
	}

	private static void ensureInit() {
		if (!initiated)
			init();
	}

	@Override
	public ModelData20 translate(RawModelData amd) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void render(ModelData20 data, IMHFCAnimatedEntity animatedEntity,
			float subFrame) {
		ensureInit();
		int currProgram = glGetInteger(GL_CURRENT_PROGRAM);
		int currVertexShader = 0;
		if (currProgram == 0) {
			glUseProgram(programName);
		} else {
			currVertexShader = GLStatics.getShader(currProgram,
					GL_VERTEX_SHADER);
			if (currVertexShader != 0) {
				glAttachShader(proxyProgram, currVertexShader);
				glDetachShader(currProgram, currVertexShader);
			}
			glAttachShader(currProgram, shaderName);
			GLStatics.linkProgramSafe(currProgram);
		}
		// TODO: enable streaming approach once finished with the modelformat
		// Stream<String> partsStream = data.getParts().stream();
		AnimationInformation info = animatedEntity.getAnimInformation();
		if (info != null) {
			MHFCAttack currAttk = info.getCurrentAttack();
			if (currAttk != null) {
				// TODO: bind in another way
				currAttk.glBindBoneMatrices(0, subFrame);
			}
			// partsStream
			// .filter((part) -> info.shouldDisplayPart(part, subFrame));
		}
		// partsStream.forEach(this::renderPart);

		if (currProgram != 0) {
			glDetachShader(currProgram, shaderName); // Can safely detach
			if (currVertexShader != 0) {
				glAttachShader(currProgram, currVertexShader);
				glDetachShader(proxyProgram, currVertexShader);
			}
			GLStatics.linkProgramSafe(currProgram);
		}
		glUseProgram(currProgram);
	}

	protected void renderPart(String string) {
		// TODO: make this renderPart(Part part);
	}
}
