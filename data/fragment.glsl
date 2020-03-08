#version 450 core
in vec4 color;
in vec2 uv;

out vec4 f_color;


void main() {
    f_color = color;
}