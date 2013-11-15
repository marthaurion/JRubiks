JRubiks
=======

for java implementation of a rubik's cube

Note: The way I have it now, the Up face and Down face arrays are sort of parallel.
The four other faces are all parallel to each other going around.
So the top of the face is the top of array.
For the Up and Down faces, the back of the face on the cube is the top of the array.


Things that have been done:
- The cube can take a space-delimited string input and run those moves on the cube.
- Cube prints out faces


Things to be done:
- Allow for cube rotations.
- Create a scrambler.
- Find a more elegant way to turn the faces that doesn't involve hard-coding things if possible.
- Generalize the functions to work for all 6-sided cubes (4x4, 5x5, 2x2, etc.).
- Create a more visual representation of the cube.
- Allow different types of delimiters for algorithm input.