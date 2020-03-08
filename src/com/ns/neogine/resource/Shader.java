package com.ns.neogine.resource;

import com.ns.neogine.exception.ResourceException;
import com.ns.neogine.math.Vector2f;
import com.ns.neogine.math.Vector3f;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.lwjgl.opengl.GL45.*;

/**
 * A shader resource.
 */
public class Shader extends Resource {

	/**
	 * Path to the vertex shader file.
	 */
	private String _vertex_path;
	/**
	 * Path to the fragment shader file.
	 */
	private String _fragment_path;

	/**
	 * Linked OpenGL shader program.
	 */
	private int _program;


	/**
	 * Constructor.
	 *
	 * @param vp Path to the vertex shader file.
	 * @param fp Path to the fragment shader file.
	 */
	public Shader(String vp, String fp) {
		_vertex_path = vp;
		_fragment_path = fp;
		_program = 0;
	}


	/**
	 * Uses the shader for the next draw calls.
	 */
	public void use() {
		if( _program == 0 )
			throw new IllegalStateException("Shader is not loaded.");

		glUseProgram(_program);
	}


	/**
	 * Sets a int uniform.
	 *
	 * @param name  Name of the uniform location.
	 * @param value Value to set.
	 */
	public void set(String name, int value) {
		int uniform = glGetUniformLocation(_program, name);

		if( uniform == -1 )
			throw new IllegalArgumentException(
				String.format("Location '%s' not found.", name)
			);

		use();
		glUniform1i(uniform, value);
	}

	/**
	 * Sets a float uniform.
	 *
	 * @param name  Name of the uniform location.
	 * @param value Value to set.
	 */
	public void set(String name, float value) {
		int uniform = glGetUniformLocation(_program, name);

		if( uniform == -1 )
			throw new IllegalArgumentException(
				String.format("Location '%s' not found.", name)
			);

		use();
		glUniform1f(uniform, value);
	}

	/**
	 * Sets a double uniform.
	 *
	 * @param name  Name of the uniform location.
	 * @param value Value to set.
	 */
	public void set(String name, double value) {
		int uniform = glGetUniformLocation(_program, name);

		if( uniform == -1 )
			throw new IllegalArgumentException(
				String.format("Location '%s' not found.", name)
			);

		use();
		glUniform1d(uniform, value);
	}

	/**
	 * Sets a Vector2 uniform.
	 *
	 * @param name  Name of the uniform location.
	 * @param value Value to set.
	 */
	public void set(String name, Vector2f value) {
		int uniform = glGetUniformLocation(_program, name);

		if( uniform == -1 )
			throw new IllegalArgumentException(
				String.format("Location '%s' not found.", name)
			);

		use();
		glUniform2f(uniform, value.x, value.y);
	}

	/**
	 * Sets a Vector3 uniform.
	 *
	 * @param name  Name of the uniform location.
	 * @param value Value to set.
	 */
	public void set(String name, Vector3f value) {
		int uniform = glGetUniformLocation(_program, name);

		if( uniform == -1 )
			throw new IllegalArgumentException(
				String.format("Location '%s' not found.", name)
			);

		use();
		glUniform3f(uniform, value.x, value.y, value.z);
	}


	/**
	 * Loads the resource.
	 *
	 * @throws ResourceException when an error occures while loading
	 *                           the resource.
	 */
	@Override
	public void load() throws ResourceException {
		int vertex_shader, fragment_shader;

		// Loads the vertex shader. If an exception is thrown, it will be
		// sent upward, no need to catch it.
		vertex_shader = _loadShader(GL_VERTEX_SHADER, _vertex_path);

		// Loads the fragment shader. If an exception is thrown, we delete
		// the vertex shader before throwing the exception again.
		try {
			fragment_shader = _loadShader(GL_FRAGMENT_SHADER, _fragment_path);
		} catch( ResourceException ex ) {
			glDeleteShader(vertex_shader);
			throw ex;
		}

		// Creates the program, attaches both shaders to it and link it.
		int program = glCreateProgram();
		glAttachShader(program, vertex_shader);
		glAttachShader(program, fragment_shader);
		glLinkProgram(program);

		// If the link failed
		if( glGetProgrami(program, GL_LINK_STATUS) != GL_TRUE ) {
			String error = glGetProgramInfoLog(program);
			glDeleteShader(vertex_shader);
			glDeleteShader(fragment_shader);
			glDeleteProgram(program);
			throw new ResourceException(
				"shader", _vertex_path,
				"Failed to link the shader program : " + error
			);
		}

		// Keeps the program ID, and deletes the two shader.
		_program = program;
		glDeleteShader(vertex_shader);
		glDeleteShader(fragment_shader);
	}

	/**
	 * Unloads the resource.
	 */
	@Override
	public void unload() {
		if( _program != 0 )
			glDeleteProgram(_program);
	}


	/**
	 * Loads a shader.
	 *
	 * @param type Type of the shader (GL_VERTEX_SHADER, ...)
	 * @param path Path to the file containing the shader.
	 * @return The ID of the GL Shader object.
	 * @throws ResourceException when an error occurs while loading the
	 *                           shader.
	 */
	private int _loadShader(int type, String path) throws ResourceException {
		String source;

		// loads the source code of the shader
		try {
			source = new String(Files.readAllBytes(Paths.get(path)));
		} catch( IOException ex ) {
			throw new ResourceException(
				"shader", path,
				"Failed to obtain the shader source code.",
				ex
			);
		}

		// creates the shader, sends it source code an compiles it
		int shader = glCreateShader(type);
		glShaderSource(shader, source);
		glCompileShader(shader);

		// if the compilation failed
		if( glGetShaderi(shader, GL_COMPILE_STATUS) != GL_TRUE ) {
			String error = glGetShaderInfoLog(shader);
			glDeleteShader(shader);
			throw new ResourceException(
				"shader", path,
				"Failed to compile the shader : " + error
			);
		}

		return shader;
	}
}
