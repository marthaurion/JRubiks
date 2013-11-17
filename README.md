JRubiks
=======

for java implementation of a rubik's cube

Note: The way I have it now, the Up face and Down face arrays are sort of parallel.
The four other faces are all parallel to each other going around.
So the top of the face is the top of array.
For the Up and Down faces, the back of the face on the cube is the top of the array.


Things that have been done:
- The cube can take a string input and run those moves on the cube.
- String input can be delimited by anything. Default is space.
- Cube prints out faces.
- Generalized functions for multiple sizes. Tested on 3x3, 4x4.
- Cube rotations implemented as public functions.


Things to be done:
- Generalized cube rotations. Need counter-clock and twice.
- Create a scrambler.
- Find a more elegant way to turn the faces that doesn't involve hard-coding things if possible.
- Test generalized functions on higher-order cubes (5x5+).
- Create a more visual representation of the cube.
- Allow different types of delimiters for algorithm input.