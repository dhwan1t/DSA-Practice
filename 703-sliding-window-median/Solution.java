class Solution {

    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] res = new double[nums.length - k + 1];
        PriorityQueue<Integer> pq1 = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> pq2 = new PriorityQueue<>();
        Map<Integer, Integer> map = new HashMap<>();

        int l = 0;

        if (k % 2 == 0) {
            for (int i = 0; i < k; i++) {
                pq2.offer(nums[i]);

                if (pq1.size() < pq2.size()) {
                    pq1.offer(pq2.poll());
                }
                if (!pq1.isEmpty() && !pq2.isEmpty() && pq1.peek() > pq2.peek()) {
                    int a = pq1.poll();
                    int b = pq2.poll();
                    pq1.offer(b);
                    pq2.offer(a);
                }
            }

            res[l++] = ((double) pq1.peek() + pq2.peek()) / 2;

            int j = k;
            int i = 0;

            int size1 = pq1.size();
            int size2 = pq2.size();
            while (j < nums.length) {
                int x = nums[i];






                map.put(x, map.getOrDefault(x, 0) + 1);
                if (pq1.size() > 0 && x <= pq1.peek()) {
                    size1--;
                } else {
                    size2--;
                }
                
                if(nums[j] <= pq1.peek()){
                    pq1.offer(nums[j]);
                    size1++;
                }
                else{
                    pq2.offer(nums[j]);
                    size2++;
                }
                
                while (!pq1.isEmpty() && map.containsKey(pq1.peek())) {
                    int y = pq1.poll();
                    if (map.get(y) == 1) {
                        map.remove(y);
                    } else {
                        map.put(y, map.get(y) - 1);
                    }

                }
                while (!pq2.isEmpty() && map.containsKey(pq2.peek())) {
                    int y = pq2.poll();
                    if (map.get(y) == 1) {
                        map.remove(y);
                    } else {
                        map.put(y, map.get(y) - 1);
                    }
                }
                if (size1 > size2 + 1) {
                    pq2.offer(pq1.poll());
                    size2++;
                    size1--;
                } else if (size1 < size2) {
                    pq1.offer(pq2.poll());
                    size1++;
                    size2--;
                }

                while (!pq1.isEmpty() && map.containsKey(pq1.peek())) {
                    int y = pq1.poll();
                    if (map.get(y) == 1) {
                        map.remove(y);
                    } else {
                        map.put(y, map.get(y) - 1);
                    }

                }
                while (!pq2.isEmpty() && map.containsKey(pq2.peek())) {
                    int y = pq2.poll();
                    if (map.get(y) == 1) {
                        map.remove(y);
                    } else {
                        map.put(y, map.get(y) - 1);
                    }
                }





                i++;
                j++;
                res[l++] = ((double) pq1.peek() + pq2.peek()) / 2;
            }
        }

        else {
            for (int i = 0; i < k; i++) {
                pq2.offer(nums[i]);

                if (pq1.size() < pq2.size()) {
                    pq1.offer(pq2.poll());
                }
                if (!pq1.isEmpty() && !pq2.isEmpty() && pq1.peek() > pq2.peek()) {
                    int a = pq1.poll();
                    int b = pq2.poll();
                    pq1.offer(b);
                    pq2.offer(a);
                }
            }

            res[l++] = pq1.peek();

            int i = 0;
            int j = k;

            int size1 = pq1.size();
            int size2 = pq2.size();
            while (j < nums.length) {
                int x = nums[i];

                map.put(x, map.getOrDefault(x, 0) + 1);
                if (pq1.size() > 0 && x <= pq1.peek()) {
                    size1--;
                } else {
                    size2--;
                }
                if(nums[j] <= pq1.peek()){
                    pq1.offer(nums[j]);
                    size1++;
                }else {
                    pq2.offer(nums[j]);
                    size2++;
                }
                while (!pq1.isEmpty() && map.containsKey(pq1.peek())) {
                    int y = pq1.poll();
                    if (map.get(y) == 1) {
                        map.remove(y);
                    } else {
                        map.put(y, map.get(y) - 1);
                    }

                }
                while (!pq2.isEmpty() && map.containsKey(pq2.peek())) {
                    int y = pq2.poll();
                    if (map.get(y) == 1) {
                        map.remove(y);
                    } else {
                        map.put(y, map.get(y) - 1);
                    }
                }
                if (size1 > size2 + 1) {
                    pq2.offer(pq1.poll());
                    size2++;
                    size1--;
                } else if (size1 < size2) {
                    pq1.offer(pq2.poll());
                    size1++;
                    size2--;
                }

                while (!pq1.isEmpty() && map.containsKey(pq1.peek())) {
                    int y = pq1.poll();
                    if (map.get(y) == 1) {
                        map.remove(y);
                    } else {
                        map.put(y, map.get(y) - 1);
                    }

                }
                while (!pq2.isEmpty() && map.containsKey(pq2.peek())) {
                    int y = pq2.poll();
                    if (map.get(y) == 1) {
                        map.remove(y);
                    } else {
                        map.put(y, map.get(y) - 1);
                    }
                }

                res[l++] = (double) pq1.peek();
                i++;
                j++;
            }
        }
        return res;
    }
}