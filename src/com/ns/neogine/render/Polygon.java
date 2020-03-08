package com.ns.neogine.render;

import com.ns.neogine.exception.RenderException;
import com.ns.neogine.math.Color;
import com.ns.neogine.math.Vector2f;
import com.ns.neogine.math.Vector3f;
import com.ns.neogine.utils.ArrayUtils;

import static org.lwjgl.opengl.GL45.*;

public class Polygon {
	private int _vao;
	private int _vbo;
	private int _ebo;

	private PolygonUpdateMode _update_mode;
	private PolygonRenderMode _render_mode;
	private PolygonDataMode _data_mode;

	private int _count;


	public Polygon(PolygonUpdateMode u, PolygonRenderMode r, PolygonDataMode d) {
		_vao = 0;
		_vbo = 0;
		_ebo = 0;

		_update_mode = u;
		_render_mode = r;
		_data_mode = d;

		_count = 0;
	}


	public void bind() {
		glBindVertexArray(_vao);
	}

	public void draw() {
		bind();

		if( _data_mode.hasIndexes() ) {
			glDrawElements(_render_mode.code, _count, GL_INT, 0);
		} else {
			glDrawArrays(_render_mode.code, 0, _count);
		}
	}

	public void delete() {
		if( _vao != 0 )
			glDeleteVertexArrays(_vao);

		if( _vbo != 0 )
			glDeleteBuffers(_vbo);

		if( _ebo != 0 )
			glDeleteBuffers(_ebo);
	}


	public void setData(Vector2f[] vertices) throws RenderException {
		if( _data_mode != PolygonDataMode.Array )
			throw new RenderException("Data mode isn't VERTEX.");

		float[] data = ArrayUtils.expend(vertices);

		setData(2, data, null);

		_count = vertices.length;
	}

	public void setData(Vector3f[] vertices) throws RenderException {
		if( _data_mode != PolygonDataMode.Array )
			throw new RenderException("Data mode isn't VERTEX.");

		float[] data = ArrayUtils.expend(vertices);

		setData(3, data, null);
		_count = vertices.length;
	}

	public void setData(Vector2f[] vertices, Color[] colors) throws RenderException {
		if( _data_mode != PolygonDataMode.ArrayColor )
			throw new RenderException("Data mode isn't VERTEX+COLOR.");

		float[] vbuf = ArrayUtils.expend(vertices);
		float[] cbuf = ArrayUtils.expend(colors);
		float[] data = ArrayUtils.intertwine(
			new int[]{2, 4},
			vbuf, cbuf
		);

		setData(2, data, null);
		_count = vertices.length;
	}

	public void setData(Vector3f[] vertices, Color[] colors) throws RenderException {
		if( _data_mode != PolygonDataMode.ArrayColor )
			throw new RenderException("Data mode isn't VERTEX+COLOR.");

		float[] vbuf = ArrayUtils.expend(vertices);
		float[] cbuf = ArrayUtils.expend(colors);
		float[] data = ArrayUtils.intertwine(
			new int[]{3, 4},
			vbuf, cbuf
		);

		setData(3, data, null);
		_count = vertices.length;
	}

	public void setData(Vector2f[] vertices, Vector2f[] uvs) throws RenderException {
		if( _data_mode != PolygonDataMode.ArrayTexture )
			throw new RenderException("Data mode isn't VERTEX+TEXTURE.");

		float[] vbuf = ArrayUtils.expend(vertices);
		float[] uvbuf = ArrayUtils.expend(uvs);
		float[] data = ArrayUtils.intertwine(
			new int[]{2, 2},
			vbuf, uvbuf
		);

		setData(2, data, null);
		_count = vertices.length;
	}

	public void setData(Vector3f[] vertices, Vector2f[] uvs) throws RenderException {
		if( _data_mode != PolygonDataMode.ArrayTexture )
			throw new RenderException("Data mode isn't VERTEX+TEXTURE.");

		float[] vbuf = ArrayUtils.expend(vertices);
		float[] uvbuf = ArrayUtils.expend(uvs);
		float[] data = ArrayUtils.intertwine(
			new int[]{3, 2},
			vbuf, uvbuf
		);

		setData(3, data, null);
		_count = vertices.length;
	}

	public void setData(Vector2f[] vertices, int[] idxs) throws RenderException {
		if( _data_mode != PolygonDataMode.ArrayIndex )
			throw new RenderException("Data mode isn't VERTEX+INDEX");

		float[] data = ArrayUtils.expend(vertices);

		setData(2, data, idxs);
		_count = idxs.length;
	}

	public void setData(Vector3f[] vertices, int[] idxs) throws RenderException {
		if( _data_mode != PolygonDataMode.ArrayIndex )
			throw new RenderException("Data mode isn't VERTEX+INDEX");

		float[] data = ArrayUtils.expend(vertices);

		setData(3, data, idxs);
		_count = idxs.length;
	}

	public void setData(Vector2f[] vertices, Color[] colors, Vector2f[] uvs) throws RenderException {
		if( _data_mode != PolygonDataMode.ArrayColorTexture )
			throw new RenderException("Data mode isn't VERTEX+COLOR+TEXTURE.");

		float[] vbuf = ArrayUtils.expend(vertices);
		float[] cbuf = ArrayUtils.expend(colors);
		float[] uvbuf = ArrayUtils.expend(uvs);
		float[] data = ArrayUtils.intertwine(
			new int[]{2, 4, 2},
			vbuf, cbuf, uvbuf
		);

		setData(2, data, null);
		_count = vertices.length;
	}

	public void setData(Vector3f[] vertices, Color[] colors, Vector2f[] uvs) throws RenderException {
		if( _data_mode != PolygonDataMode.ArrayColorTexture )
			throw new RenderException("Data mode isn't VERTEX+COLOR+TEXTURE.");

		float[] vbuf = ArrayUtils.expend(vertices);
		float[] cbuf = ArrayUtils.expend(colors);
		float[] uvbuf = ArrayUtils.expend(uvs);
		float[] data = ArrayUtils.intertwine(
			new int[]{3, 4, 2},
			vbuf, cbuf, uvbuf
		);

		setData(3, data, null);
		_count = vertices.length;
	}

	public void setData(Vector2f[] vertices, Color[] colors, int[] idxs) throws RenderException {
		if( _data_mode != PolygonDataMode.ArrayColorIndex )
			throw new RenderException("Data mode isn't VERTEX+COLOR+INDEX.");

		float[] vbuf = ArrayUtils.expend(vertices);
		float[] cbuf = ArrayUtils.expend(colors);
		float[] data = ArrayUtils.intertwine(
			new int[]{2, 4},
			vbuf, cbuf
		);

		setData(2, data, idxs);
		_count = idxs.length;
	}

	public void setData(Vector3f[] vertices, Color[] colors, int[] idxs) throws RenderException {
		if( _data_mode != PolygonDataMode.ArrayColorIndex )
			throw new RenderException("Data mode isn't VERTEX+COLOR+INDEX.");

		float[] vbuf = ArrayUtils.expend(vertices);
		float[] cbuf = ArrayUtils.expend(colors);
		float[] data = ArrayUtils.intertwine(
			new int[]{3, 4},
			vbuf, cbuf
		);

		setData(3, data, idxs);
		_count = idxs.length;
	}

	public void setData(Vector2f[] vertices, Color[] colors, Vector2f[] uvs, int[] idxs) throws RenderException {
		if( _data_mode != PolygonDataMode.ArrayColorTextureIndex )
			throw new RenderException("Data mode isn't VERTEX+COLOR+TEXTURE+INDEX.");

		float[] vbuf = ArrayUtils.expend(vertices);
		float[] cbuf = ArrayUtils.expend(colors);
		float[] uvbuf = ArrayUtils.expend(uvs);
		float[] data = ArrayUtils.intertwine(
			new int[]{2, 4, 2},
			vbuf, cbuf, uvbuf
		);

		setData(2, data, idxs);
		_count = idxs.length;
	}

	public void setData(Vector3f[] vertices, Color[] colors, Vector2f[] uvs, int[] idxs) throws RenderException {
		if( _data_mode != PolygonDataMode.ArrayColorTextureIndex )
			throw new RenderException("Data mode isn't VERTEX+COLOR+TEXTURE+INDEX.");

		float[] vbuf = ArrayUtils.expend(vertices);
		float[] cbuf = ArrayUtils.expend(colors);
		float[] uvbuf = ArrayUtils.expend(uvs);
		float[] data = ArrayUtils.intertwine(
			new int[]{3, 4, 2},
			vbuf, cbuf, uvbuf
		);

		setData(3, data, idxs);
		_count = idxs.length;
	}


	private void setData(int vcount, float[] data, int[] indexes) {
		generateBuffers();
		setVboData(data);

		int stride = setAttributeVertex(vcount);

		if( _data_mode.hasColors() )
			setAttributeColor(vcount, stride);

		if( _data_mode.hasTextures() )
			setAttributeTexture(vcount, stride);

		if( _data_mode.hasIndexes() )
			setEboData(indexes);

		unbindAll();
	}

	private void generateBuffers() {
		if( _vao == 0 )
			_vao = glGenVertexArrays();

		if( _vbo == 0 )
			_vbo = glGenBuffers();

		if( _ebo == 0 && _data_mode.hasIndexes() )
			_ebo = glGenBuffers();

		glBindVertexArray(_vao);
	}

	private void setVboData(float[] data) {
		glBindBuffer(GL_ARRAY_BUFFER, _vbo);
		glBufferData(GL_ARRAY_BUFFER, data, _update_mode.code);
	}

	private void setEboData(int[] data) {
		glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, _ebo);
		glBufferData(GL_ELEMENT_ARRAY_BUFFER, data, _update_mode.code);
	}

	private int setAttributeVertex(int vcount) {
		int stride = vcount;

		if( _data_mode.hasColors() )
			stride += 4;
		if( _data_mode.hasTextures() )
			stride += 2;

		stride *= Float.BYTES;

		glVertexAttribPointer(
			0, vcount, GL_FLOAT, false,
			stride, 0
		);
		glEnableVertexAttribArray(0);

		return stride;
	}

	private void setAttributeColor(int vcount, int stride) {
		glVertexAttribPointer(
			1, 4, GL_FLOAT, true,
			stride, vcount * Float.BYTES
		);
		glEnableVertexAttribArray(1);
	}

	private void setAttributeTexture(int vcount, int stride) {
		if( _data_mode.hasColors() ) {
			glVertexAttribPointer(
				2, 2, GL_FLOAT, false,
				stride, (vcount + 4) * Float.BYTES
			);
			glEnableVertexAttribArray(2);
		} else {
			glVertexAttribPointer(
				2, 2, GL_FLOAT, false,
				stride, vcount * Float.BYTES
			);
			glEnableVertexAttribArray(2);
		}
	}

	private void unbindAll() {
		glBindVertexArray(0);
		glBindBuffer(GL_ARRAY_BUFFER, 0);
		glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, 0);
	}
}
