@startuml

class Main

Main --> gui.scene.LoadScene
Main --> gui.scene.QuizScene

gui.scene.QuizScene --> gui.object.Radical
gui.scene.QuizScene --> gui.object.RadicalTarget

Main --> util.Logger
Main --> util.DBConnection

Main --> util.object.AppData

@enduml