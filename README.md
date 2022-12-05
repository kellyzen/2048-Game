# 2048 Game
### Kelly Tan Kai Ling (20310184)
## COMPILATION

## FEATURES
### Launch
- Click "PLAY" button to start game
### Login
- Enter username in textbox
- "Clear" button to clear texts in textbox
- "Submit" button to proceed to Menu
### Menu
- Theme dropdown to change game theme colour (Dark, Light, Fantasy, Nymph, Default)
- Difficulty toggle switch to on/off difficulty level
- "<"/">" to change game mode (3x3, 4x4, 5x5, 6x6)
- "Start Game" button to proceed to game
- "Rank" button to view podium and rank table
- "Quit" button to quit game
### Game
- Click AWSD or up/down/left/right key to move cells
- Click 'G' key to end game
- Displays high score and highest tile achieved
### End Game
- Displays high score and highest tile achieved
- "Quit" button to quit game
- "Back To Menu" button to proceed to Menu

## PROGRAM"S STRUCTURE (com/example/game)
### New Java Classes & Packages
#### /audio
- MediaPlayer (interface)
- AudioPlayer (class)
***
#### /components/buttonComponent
- ButtonComponent (class)
#### /components/dialogComponent
- DialogComponent (interface)
- ConfirmationDialog (class)
- WarningDialog (class)
- CongratulationDialog (class)
- QuitDialog (class)
#### /components/textComponent
- TextComponent (class)
#### /components/toggleSwitchComponent
- ToggleSwitchComponent (class)
***
#### /resource
- Resource (interface)
- ResourcePath (abstract)
- ResourceDirectory (class)
#### /resource/directory
- ResourceBgm (class)
- ResourceDocuments (class)
- ResourceGUI (class)
- ResourceImages (class)
- ResourceStyling (class)
***
#### /scene/account
- AccountController (class)
- FileHandler (class)
- Username (class)
#### /scene/game
- IGameDifficulty (interface)
- IGameMode (interface)
- GameDifficulty (class)
- GameMode (class)
- GameState (class)
#### /scene/game/cell
- NewCell (interface)
- CreateRandomCell (class)
#### /scene/game/move
- Movable (interface)
- Movement (class)
- MoveFactory (class)
- MoveUp (class)
- MoveDown (class)
- MoveLeft (class)
- MoveRight (class)
- ValidDestination (class)
#### /scene/launch
- LaunchController (class)
#### /scene/menu
- Menu (class)
- MenuController (class)
#### /scene/rank
- Rank (class)
- RankController (class)
***
#### /theme
- ITheme (interface)
- IBackgroundScene (interface)
- Theme (class)
- BackgroundScene (class)

### Modified Java Classes & Packages (com/example/game)
- GameApp (class)
#### /scene/account
- Account (class)
#### /scene/endGame
- EndGame (class)
#### /scene/game
- GameScene (class)
#### /scene/game/cell
- Cell (class)
- TextMaker (class)
