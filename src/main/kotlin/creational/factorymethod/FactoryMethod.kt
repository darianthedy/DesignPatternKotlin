package creational.factorymethod

interface Interviewer {
    fun askInterviewQuestions()
}

class Developer: Interviewer {
    override fun askInterviewQuestions() {
        println("Developer taking interview")
    }
}

class CommunityExecutive: Interviewer {
    override fun askInterviewQuestions() {
        println("Community executive taking interview")
    }
}

abstract class HiringManager {

    protected abstract fun makeInterviewer(): Interviewer

    fun takeInterview() {
        val interviewer = makeInterviewer()
        interviewer.askInterviewQuestions()
    }
}

class DevelopmentManager: HiringManager() {
    override fun makeInterviewer(): Interviewer {
        return Developer()
    }
}

class MarketingManager: HiringManager() {
    override fun makeInterviewer(): Interviewer {
        return CommunityExecutive()
    }
}

fun main() {
    val developmentManager = DevelopmentManager()
    developmentManager.takeInterview()

    val marketingManager = MarketingManager()
    marketingManager.takeInterview()
}
