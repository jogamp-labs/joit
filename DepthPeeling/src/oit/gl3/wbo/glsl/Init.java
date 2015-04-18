/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oit.gl3.wbo.glsl;

import com.jogamp.opengl.GL3;


/**
 *
 * @author gbarbieri
 */
public class Init extends glsl.GLSLProgramObject {

    private int alphaUL;
    private int modelToWorldUL;
    private int depthScaleUL;
    private int opaqueDepthTexUL;

    public Init(GL3 gl3, String shadersFilepath, String[] vertexShaders, String[] fragmentShaders, int blockBinding) {

        super(gl3, shadersFilepath, vertexShaders, fragmentShaders);

        int projectionUBI = gl3.glGetUniformBlockIndex(getProgramId(), "vpMatrixes");
        gl3.glUniformBlockBinding(getProgramId(), projectionUBI, blockBinding);

        alphaUL = gl3.glGetUniformLocation(getProgramId(), "alpha");

        modelToWorldUL = gl3.glGetUniformLocation(getProgramId(), "modelToWorld");

        depthScaleUL = gl3.glGetUniformLocation(getProgramId(), "depthScale");

        opaqueDepthTexUL = gl3.glGetUniformLocation(getProgramId(), "opaqueDepthTex");

        if (projectionUBI == -1 || alphaUL == -1 || modelToWorldUL == -1
                || depthScaleUL == -1 || opaqueDepthTexUL == -1) {
            System.out.println("[Init] UL error");
        }
    }

    public int getAlphaUL() {
        return alphaUL;
    }

    public int getModelToWorldUL() {
        return modelToWorldUL;
    }

    public int getDepthScaleUL() {
        return depthScaleUL;
    }

    public int getOpaqueDepthTexUL() {
        return opaqueDepthTexUL;
    }
}
