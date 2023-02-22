package Heaps;
// Leetcode problem statement ->
/*You are given n​​​​​​ tasks labeled from 0 to n - 1 represented by a 2D integer array tasks, where tasks[i] = [enqueueTimei, processingTimei] means that the i​​​​​​th​​​​ task will be available to process at enqueueTimei and will take processingTimei to finish processing.

You have a single-threaded CPU that can process at most one task at a time and will act in the following way:

If the CPU is idle and there are no available tasks to process, the CPU remains idle.
If the CPU is idle and there are available tasks, the CPU will choose the one with the shortest processing time. If multiple tasks have the same shortest processing time, it will choose the task with the smallest index.
Once a task is started, the CPU will process the entire task without stopping.
The CPU can finish a task then start a new one instantly.
Return the order in which the CPU will process the tasks. */

import java.util.*;

// In task array task[0] is the enque time and task[1] is the processing time for the given task. There are task.length tasks.
// Return the order in which the CPU will process the tasks.

public class Single_Threaded_CPU {
    public static void main(String[] args) {
        int tasks[][] = { { 1, 2 }, { 2, 4 }, { 3, 2 }, { 4, 1 } };
        int ans[] = getOrder(tasks);

        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i]+" ");
        }
    }

    public static int[] getOrder(int[][] tasks) {
        int n = tasks.length;

        Task arr[] = new Task[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Task(tasks[i][0], tasks[i][1], i);
        }

        Arrays.sort(arr, (a, b) -> {
            return Integer.compare(a.enqueTime, b.enqueTime);
        });

        PriorityQueue<Task> pq = new PriorityQueue<>((a, b) -> {
            return a.processingTime == b.processingTime ? a.index - b.index : a.processingTime - b.processingTime;
        });

        int ans[] = new int[n];
        int ai = 0; // help to answer array
        int ti = 0; // help in task array
        int currTime = 0;

        while (ai < n) {
            while (ti < n && arr[ti].enqueTime <= currTime) {
                pq.add(arr[ti]);
                ti++;
            }

            if (pq.size() == 0) {
                currTime = arr[ti].enqueTime;
                continue;
            }

            Task bestFit = pq.remove();
            ans[ai++] = bestFit.index;
            currTime += bestFit.processingTime;
        }

        return ans;
    }

    static class Task {
        int enqueTime;
        int processingTime;
        int index;

        public Task(int e, int p, int i) {
            this.enqueTime = e;
            this.processingTime = p;
            this.index = i;
        }
    }
}
