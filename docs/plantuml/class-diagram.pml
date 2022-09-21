@startuml

class Main

Main --> gui.controller.LoadScene
Main --> gui.controller.QuizScene
Main --> gui.controller.EditorScene

Main --> util.Logger
util.Logger --> util.object.AppData

Main --> util.connector.DBConnector

Main --> util.Scheduler
util.Scheduler --> util.connector.DBConnector

@enduml