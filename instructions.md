Introduction

The objective of this homework is to develop an RPG battle simulator, where you can create a party of warriors and wizards to fight other parties to determine the winner. This will be a warmup project that will not have any following in the next weeks so use it as an opportunity to learn to work with your team and practice the basics on a longer project.

Let’s walk through the details of the project:

We have two types of characters, warriors and wizards who have different attributes and combat styles You need to create character class (that cannot be instantiated) that will contain base attributes that are common for both warriors and wizards

Character:


id - unique identifier
name - String
hp - number representing the health points
isAlive - flag to determine if the Player is alive
Warrior:


stamina - number to represent a resource the warrior consumes to make an attack
strength - number to calculate how strong the warrior attack is
Wizard:


mana - number to represent a resource the wizard consumes to cast spells
intelligence - number to calculate how strong the wizard spells are



How the battle simulator works
The characters are grouped in parties and the battle will be between 2 parties. So before the battle could start you need to add warriors or wizards in both parties (the parties could have any size and could be mixed with warriors and wizards).

The battles will be 1 vs 1. So you will need to be able to choose between members of the party to duel another member from the rival party.

The battle will be by rounds, in each round both combatants will attack at the same time (so you even if one combatant do the killing blow both will take damage). So the combat could end in a tie.

When the battle is over the winner will return to the party and the loser will be removed and sent to the graveyard. Then you can choose the combatants for the next duel.

When a party lose all their members a winner party is declared.

Conditionals to validate the combatant’s condition and determinate when the fight is over and to validate when one party runs out of members.




Character Attacks
Both wizards and warriors will have the same attack command defined by an interface called Attacker.

Warriors are strong well armored characters that focus on the attribute strength. Every round a warrior will try to do a “Heavy attack”. The damage of a heavy attack is equals to their strength and every hit will decrease their stamina by 5 points. If he can’t make a heavy attack he will do a “Weak attack”. The damage of a weak attack is the half of the strength (truncate decimals). Every weak attack will recover his stamina by 1.

Wizards are the masters of the arcane their main attribute is intelligence. Every round a wizard will try to cast a “Fireball”. The damage of a fireball is equals to his intelligence and every fireball will decrease their mana by 5 points. If he can’t cast a fireball he will do a “Staff hit”. The damage of a staff hit is equals to 2. Every staff hit will recover his mana by 1.




Requirements
For this project you must accomplish all of the following:

Navigate through a text-based menu using Standard Input and Output.
Create Warriors and Wizards individually customizing their stats and name and adding them to a party.
Create a full party of randomly generated Wizards and Warriors with randomized stats considering these limits.
name: based on an array of names, pick a random position, and if is already in the party add Jr at the end.
hp: random between 100-200 to warriors, 50-100 for wizards)
stamina: random between 10-50
strength: random between 1-10
mana: random between 10-50
intelligence: random between 1-50
Import a party using a CSV file.
Show the graveyard (is the same graveyard for both parties)
The battle between parties and determines the winner.
Keep a detailed log (on the standard output) of every action taken during the duels.



Optional Achievements

Export party into an importable CSV file.
Simulate whole party fights with one command by choosing random fighters on each side and make them duel until one party is wiped out.



Important Notes

Everyone in the squad should contribute equally to the project in time and lines of code written.

All code must be reviewed before it is merged into the master branch.

All squad members must participate in code review.

Every repository should have a README.md file with clear instructions, demo files, or any documentation needed so other teams don’t have problems with the review

This is intended to be a challenging assignment. You will have to rely heavily on your teammates and independent research. Learning independently is a hallmark of a good developer and our job is to turn you into good developers. This process may be frustrating but you will learn a ton!