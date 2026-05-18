

class Solution {

    public boolean canReach(int[] arr, int start) {

        Queue<Integer> q = new LinkedList<>();

        boolean[] visited = new boolean[arr.length];

        q.offer(start);
        visited[start] = true;

        while(!q.isEmpty()) {

            int idx = q.poll();

            if(arr[idx] == 0) {
                return true;
            }

            int right = idx + arr[idx];
            int left = idx - arr[idx];

            if(right < arr.length && !visited[right]) {
                q.offer(right);
                visited[right] = true;
            }

            if(left >= 0 && !visited[left]) {
                q.offer(left);
                visited[left] = true;
            }
        }

        return false;
    }
}