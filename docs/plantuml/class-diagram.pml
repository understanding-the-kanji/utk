@startuml

class Main

Main --> gui.scenes.LoadScene
Main --> gui.scenes.QuizScene

gui.scenes.QuizScene --> gui.objects.Radical
gui.scenes.QuizScene --> gui.objects.RadicalTarget

Main --> util.Logger
Main --> util.DBConnection

Main --> util.object.AppData

@enduml