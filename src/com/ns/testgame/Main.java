package com.ns.testgame;

import com.ns.neogine.exception.RenderException;
import com.ns.neogine.exception.ResourceException;
import com.ns.neogine.game.Game;
import com.ns.neogine.game.IGame;
import com.ns.neogine.math.Color;
import com.ns.neogine.math.Vector3f;
import com.ns.neogine.render.Polygon;
import com.ns.neogine.render.PolygonDataMode;
import com.ns.neogine.render.PolygonRenderMode;
import com.ns.neogine.render.PolygonUpdateMode;
import com.ns.neogine.resource.Shader;

import static org.lwjgl.opengl.GL45.*;


public class Main implements IGame {

	private Shader _shader;
	private Polygon _polygon;

	private int _vbo;
	private int _vao;


	public Main() {

	}


	@Override
	public void load(Game game) {
		_shader = new Shader(
			"data/vertex.glsl",
			"data/fragment.glsl"
		);

		try {
			_shader.load();
		} catch( ResourceException ex ) {
			throw new IllegalStateException("Failed to load shader.", ex);
		}
	}

	@Override
	public void initialize(Game game) {
		_polygon = new Polygon(
			PolygonUpdateMode.StaticDraw,
			PolygonRenderMode.Triangles,
			PolygonDataMode.ArrayColor
		);

		try {
			_polygon.setData(new Vector3f[]{
				new Vector3f(-0.5f, -0.5f, 0.0f),
				new Vector3f(0.5f, -0.5f, 0.0f),
				new Vector3f(0.0f, 0.5f, 0.0f)
			}, new Color[]{
				new Color(1, 0, 0),
				new Color(0, 1, 0),
				new Color(0, 0, 1)
			});
		} catch( RenderException e ) {
			System.err.println(e.toString());
		}
	}

	@Override
	public void update(Game game, double dt) {

	}

	@Override
	public void render(Game game) {
		glClearColor(0.0f, 0.1f, 0.0f, 1.0f);
		glClear(GL_COLOR_BUFFER_BIT);

		_shader.use();
		_polygon.draw();
	}

	@Override
	public void shutdown(Game game) {
		_polygon.delete();
	}

	@Override
	public void unload(Game game) {
		_shader.unload();
	}
}
