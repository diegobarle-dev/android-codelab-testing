package com.example.android.architecture.blueprints.todoapp.statistics

import com.example.android.architecture.blueprints.todoapp.data.Task
import org.hamcrest.Matchers.`is`
import org.junit.Assert.*
import org.junit.Test

class StatisticsUtilsTest{

    @Test
    fun getActiveAndCompletedStats_noCompleted_returnsHundredZero() {
        // Given an active task
        val tasks = listOf(
                Task("title", "desc", isCompleted = false)
        )

        // When call your function
        val result = getActiveAndCompletedStats(tasks)

        // Then the percentages are 100 and 0
        assertThat(result.completedTasksPercent, `is` (0f))
        assertThat(result.activeTasksPercent, `is` (100f))
    }

    @Test
    fun getActiveAndCompletedStats_oneCompletedNoActive_returnsZeroHundred() {
        // Given a completed task
        val tasks = listOf(
                Task("title", "desc", isCompleted = true)
        )

        // When call your function
        val result = getActiveAndCompletedStats(tasks)

        // Then the percentages are 0 and 100
        assertThat(result.completedTasksPercent, `is` (100f))
        assertThat(result.activeTasksPercent, `is` (0f))
    }

    @Test
    fun getActiveAndCompletedStats_both_returnsFortySixty() {
        // Given 2 completed tasks and 3 active tasks
        val tasks = listOf(
                Task("title1", "desc1", isCompleted = true),
                Task("title2", "desc2", isCompleted = true),
                Task("title3", "desc3", isCompleted = false),
                Task("title4", "desc4", isCompleted = false),
                Task("title5", "desc5", isCompleted = false)
        )

        // When the list of tasks is computed
        val result = getActiveAndCompletedStats(tasks)

        // Then the result is 60-40
        assertThat(result.completedTasksPercent, `is` (40f))
        assertThat(result.activeTasksPercent, `is` (60f))
    }

    @Test
    fun getActiveAndCompletedStats_emptyTasks_returnsZeroZero() {
        // Given no tasks
        val tasks = emptyList<Task>()

        // When call your function
        val result = getActiveAndCompletedStats(tasks)

        // Both active and completed tasks are 0
        assertThat(result.completedTasksPercent, `is` (0f))
        assertThat(result.activeTasksPercent, `is` (0f))
    }

    @Test
    fun getActiveAndCompletedStats_nullTasks_returnsZeroZero() {
        // Given an error loading stats
        val tasks: List<Task>? = null

        // When call your function
        val result = getActiveAndCompletedStats(tasks)

        // Both active and completed tasks are 0
        assertThat(result.completedTasksPercent, `is` (0f))
        assertThat(result.activeTasksPercent, `is` (0f))
    }

}