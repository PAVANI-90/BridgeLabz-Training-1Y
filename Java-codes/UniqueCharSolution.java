class UniqueCharSolution {
    public int firstUniqChar(String s) {
        
        for (int i = 0; i < s.length(); i++) {
            int count = 0;
            for (int j = 0; j < s.length(); j++) {
                if (i != j && s.charAt(i) == s.charAt(j)) {
                    count++;
                }
            }
            if (count == 0) return i;
        }
        return -1;
    }
    
    
    public static void main(String[] args) {
        UniqueCharSolution sol = new UniqueCharSolution();
        System.out.println(sol.firstUniqChar("leetcode"));     // 0
        System.out.println(sol.firstUniqChar("loveleetcode")); // 2
        System.out.println(sol.firstUniqChar("aabb"));         // -1
    }
}

