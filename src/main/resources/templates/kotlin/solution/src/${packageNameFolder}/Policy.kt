package ${packageName}

class Policy(private val context: Context) {

    fun configure(timeIsImportant: Boolean, spaceIsImportant: Boolean) {
        if (timeIsImportant && !spaceIsImportant) {
            println("Time is important –> Merge Sort!")
            context.sortAlgorithm = MergeSort()
        } else if (timeIsImportant && spaceIsImportant) {
            println("Time & Space are important –> Quick Sort!")
            context.sortAlgorithm = QuickSort()
        }
    }
}
