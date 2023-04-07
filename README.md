# Memory-Game
A simple Memory Game
This gamee have very basic rules:

This game consist of a grid that conatians letters that you need to open ONE BY ONE then close all of them and Write the letters you remember in order.

1. You Enter the index of the rows and coloumns that you want to discover
2. They Will Show Up One By One.
3. If you miss any input or double entered the same rows and coloumns coordinates/indices. 
4. you can click 1 to add more input or click 0 to continue.
5. The program is going to ask you to write "yes" to cover the whole Grid
6. You Enter What Letters you remember in order.

## Example:

Enter the rows and colomns indices in order. ('Leave space between the numbers')
rows - colomns:0 0
C X X 
X X X 
X X X 
rows - colomns:0 1
C P X 
X X X 
X X X 
rows - colomns:0 2
C P C
X X X
X X X
rows - colomns:1 0
C P C
H X X
X X X
rows - colomns:1 1
C P C
H P X
X X X
rows - colomns:1 2
C P C
H P B
X X X
rows - colomns:2 0
C P C
H P B
U X X
rows - colomns:2 1
C P C
H P B
U B X
rows - colomns:2 1
C P C
H P B
U B X
Missed One?, press --> 1 or press --> 0 to Continue
1
rows - colomns:2 2
C P C
H P B
U B H
Missed One?, press --> 1 or press --> 0 to Continue
0
For covering write yes: yes
X X X
X X X
X X X
Enter the character in the remembered order: PCPBCHUBH
You Lose! You got 3
