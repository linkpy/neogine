#version 450 core
layout(location = 0) in vec3 i_vertex;
layout(location = 1) in vec4 i_color;
layout(location = 2) in vec2 i_uv;

out vec4 color;
out vec2 uv;

void main() {
    gl_Position = vec4(i_vertex, 1.0);
    color = i_color;
    uv = i_uv;
}
