>Kelly Tan Kai Ling (20310184)
# 2048 Game
## COMPILATION
### Installing Java IDE (please proceed to the next section if you had done this)
1. Download [IntelliJ](https://www.jetbrains.com/idea/download/), [Eclipse](https://www.eclipse.org/downloads/), [Netbeans](https://netbeans.apache.org/download/index.html) or any preferred Java IDE of your choice.
2. Install the Java IDE using the downloaded installer along with JDK and direct the installation to your preferred path.
### Downloading files
3. Download _ALL_ the files and place it in "IdeaProjects" folder.
### Run 2048 Game
4. Run GameApp.java ``src/main/java/com/example/game/GameApp.java``

## FEATURES
### Launch
![Launch Scene](readme/images/launch.png)
- [x] Click "PLAY" button to start game
### Login
![Login Scene](readme/images/login.png)
- [x] Enter username in textbox
- [x] "Clear" button to clear texts in textbox
- [x] "Submit" button to proceed to Menu
### Menu
![Menu Scene](readme/images/menu.png)
- [x] Theme dropdown to change game theme colour (Dark, Light, Fantasy, Nymph, Default)
- [x] Difficulty toggle switch to on/off difficulty level
- [x] "<" or ">" button to change game mode (3x3, 4x4, 5x5, 6x6)
- [x] "Start Game" button to proceed to game
- [x] "Rank" button to view podium and rank table
- [x] "Quit" button to quit game
- [x] Slider to adjust bgm volume
- [ ] "Next" button to change bgm (not yet implement)
### Rank
![Rank Scene](readme/images/rank.png)
- [x] Displays top 3 podium
- [x] Displays rank table
- [x] "Back To Menu" button to proceed to Menu
### Game
![Game Scene](readme/images/game.png)
- [x] Click AWSD or up/down/left/right key to move cells
- [x] Click 'G' key to end game
- [x] Displays high score and highest tile achieved
### End Game
![End Game Scene](readme/images/end_game.png)
- [x] Displays high score and highest tile achieved
- [x] "Quit" button to quit game
- [x] "Back To Menu" button to proceed to Menu
- [ ] "Replay" button to replay game (not yet implement)

## PROGRAM'S STRUCTURE 
```src/main/java/com/example/game```
### New Java Classes & Packages
#### ``/audio``
- MediaPlayer (interface)
- AudioPlayer (class)
***
#### ``/components/buttonComponent``
- ButtonComponent (class)
#### ``/components/dialogComponent``
- DialogComponent (interface)
- ConfirmationDialog (class)
- WarningDialog (class)
- CongratulationDialog (class)
- QuitDialog (class)
#### ``/components/textComponent``
- TextComponent (class)
#### ``/components/toggleSwitchComponent``
- ToggleSwitchComponent (class)
***
#### ``/resource``
- Resource (interface)
- ResourcePath (abstract)
- ResourceDirectory (class)
#### ``/resource/directory``
- ResourceBgm (class)
- ResourceDocuments (class)
- ResourceGUI (class)
- ResourceImages (class)
- ResourceStyling (class)
***
#### ``/scene/account``
- AccountController (class)
- FileHandler (class)
- Username (class)
#### ``/scene/game``
- IGameDifficulty (interface)
- IGameMode (interface)
- GameDifficulty (class)
- GameMode (class)
- GameState (class)
#### ``/scene/game/cell``
- NewCell (interface)
- CreateRandomCell (class)
#### ``/scene/game/move``
- Movable (interface)
- Movement (class)
- MoveFactory (class)
- MoveUp (class)
- MoveDown (class)
- MoveLeft (class)
- MoveRight (class)
- ValidDestination (class)
#### ``/scene/launch``
- LaunchController (class)
#### ``/scene/menu``
- Menu (class)
- MenuController (class)
#### ``/scene/rank``
- Rank (class)
- RankController (class)
***
#### ``/theme``
- ITheme (interface)
- IBackgroundScene (interface)
- Theme (class)
- BackgroundScene (class)

### Modified Java Classes & Packages
```src/main/java/com/example/game```
- GameApp (class)
#### ``/scene/account``
- Account (class)
#### ``/scene/endGame``
- EndGame (class)
#### ``/scene/game``
- GameScene (class)
#### ``/scene/game/cell``
- Cell (class)
- TextMaker (class)

## UNIT TEST
```Test/com/example/game/account```
- UsernameTest

## REFERENCES
- [Theme styling](https://gist.github.com/genmancoder/146bad2111bfabed1b04d894926c83d8)
- [Toggle switch button](https://gist.github.com/TheItachiUchiha/12e40a6f3af6e1eb6f75)
