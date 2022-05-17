##Problem statement
https://workat.tech/machine-coding/practice/snake-and-ladder-problem-zgtac9lxwntg

##Rules of the game
1. The board will have 100 cells numbered from 1 to 100.
2. The game will have a six sided dice numbered from 1 to 6 and will always give a random number on rolling it.
3. Each player has a piece which is initially kept outside the board (i.e., at position 0).
4. Each player rolls the dice when their turn comes.
5. Based on the dice value, the player moves their piece forward that number of cells. Ex: If the dice value is 5 and the piece is at position 21, the player will put their piece at position 26 now (21+5).
6. A player wins if it exactly reaches the position 100 and the game ends there.
7. After the dice roll, if a piece is supposed to move outside position 100, it does not move.
8. The board also contains some snakes and ladders.
9. Each snake will have its head at some number and its tail at a smaller number.
10. Whenever a piece ends up at a position with the head of the snake, the piece should go down to the position of the tail of that snake.
11. Each ladder will have its start position at some number and end position at a larger number.
12. Whenever a piece ends up at a position with the start of the ladder, the piece should go up to the position of the end of that ladder.
13. There could be another snake/ladder at the tail of the snake or the end position of the ladder and the piece should go up/down accordingly.

##Assumptions you can take apart from those already mentioned in rules
1. There won’t be a snake at 100.
2. There won’t be multiple snakes/ladders at the same start/head point.
3. It is possible to reach 100, i.e., it is possible to win the game.
4. Snakes and Ladders do not form an infinite loop.

##Sample CLI input
This is in the format of:

```
Number of players
...
Player names
...
Number of snakes
...
Head and tail of snake
...
Number of ladders
...
Base and top of ladder
...
```
Example:
```
2
Bob
Alice
5
62 5
33 6
49 9
88 16
41 20
5
2 37
27 46
10 32
51 68
61 79
```