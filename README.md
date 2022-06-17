# Welcome to WIZARDS vs WARRIORS!

**Wizards vs Warriors** is a text-based game, consisting in fights between individual fighters from two opposing armies. 

It has been created for the first group homework assignment in the 2021 Ironhack's Full-Stack Part-Time Bootcamp by **The Overriders**,  a multidisciplinary team of *developing developers*, formed by (in alphabetical order): [David Díaz](https://github.com/daviddiazmartinez), [José Antonio Peño](https://github.com/josepebel), [Luis Badolato](https://github.com/luisbadolato), [María Campaña](https://github.com/Johari-lab) and [Pablo Gutiérrez García-Pardo](https://github.com/pablopggp).

The project took three weeks to complete and has tested not only the team's ~~patience~~ developing skills, but also their creativity and problem-solving skills.

## Features
Some of the game's most interesting requisites / features are:
* Custom / Random Party Creation.
* Custom / Random Fighter Creation.
* Importing / Exporting Armies from / to CSV files.
* Non-linear game flow (sort of...).
* Automatized Ornated Text.
* High fidelity ASCII graphics.
*  Deep game world lore as reflected on such fighter names as: *Graham Shirley*, *Ornthalas Ralofina* and *Ferdinando Digby*.
* A thrilling OST composed by one of the most talented authors of his generation.

# Quick Start Guide
Here are the basics to play your first game of **Wizards and Warriors**™ (©TheOverriders):
1. **Create an Army**. *To start creating an army you can press 1 and Enter.*
2. **Set Army Name**. *Duh.*
3. **Set Army Size and Autocomplete**. *Depending on the option selected you can start manually creating fighters for your already named army or you can set an army size and let the game's magic create some fighters for you.
In this tutorial we'll decide on the size of the army to get random fighters.*
4. **Play with this army**. *Confirmation dialog to set the army just created as one of the battle contenders.*
5. **Create Army / Set Name / Set Size / Play**. *We repeat the same process for the second army.*
6. **Start The Battle**. *With both armies already set we can start the battle!.*
7. **Choose Random Fighter**. *We trust our game's infinite wisdom and let its engine choose fighters for us.*
8. **The Dueling Begins!**. *The first fight takes place while we watch comfortably and press Enter until one of the fighters (or both) perishes.*
9. **End of Game**. *The game gets to an end when at least one of the two armies gets all of its fighters dead.*

# Game Functionality

Now that we've seen the game in action, we'll explain the rest of its functionalities: 

## Creating Armies
In the Quick Start Guide you created a random party of fighters, but what if you want more control over its creation?
Don't worry, we have the solution! You can create individual Warriors or Wizards, deciding their names and stats until you think your army is completed, or switch at any time to automated fighter creation.
After creating the army by any of the methods available we have the option to export it to a CSV file.
> ***Important***: *Any army neither selected to play nor exported to CSV will be lost forever.*

## Importing Armies
There are several places in the game flow where we are given the option to import an army using a CSV file.

## See Armies
This option is given so you can see the armies selected to play right before the battle starts.

## Start The Battle
Once both armies are set this option becomes functional and takes you to the *choose fighter selection screen*, where you can either select by name from the list of available fighters or choose randomly.
The game will then inform you about each fighter selection and the duel will begin after both fighters are selected.

## Duels and Rounds
Each time a Duel begins between two fighters a number of *Round screens* will begin appearing. In those screens we will have all the info pertaining fighter attacks and their remaining stats.

Rounds will stop happening when one of the fighters loses all of their HP. When that's the case the fighter that still lives will be proclaimed Winner of the Duel. The dead fighter(s) will be buried in **The Graveyard**™.

Then, if we still have living fighters left in both armies we are asked again to choose fighters, and the next Duel will begin.

## Ending The Game

When there are no more fighters alive in any of the armies that army will lose the battle.
Then we will be shown  **The Graveyard**™, a list with all the fallen fighters in our game.
Our game will then be over.
