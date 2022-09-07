@startuml

class Main

Main --> gui.scene.LoadScene
gui.scene.LoadScene --> gui.scene.QuizScene
gui.scene.LoadScene --> gui.scene.EditorScene

gui.scene.QuizScene --> gui.object.Radical
gui.scene.QuizScene --> gui.object.RadicalTarget

Main --> util.Logger
util.Logger --> util.object.AppData

Main --> util.Scheduler


@enduml