class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        ArrayList<String> res = new ArrayList<>();
        for( String q : queries){
            for(String d : dictionary){
                  int diff = 0;
                for(int i=0; i<q.length(); i++){
                    if(d.charAt(i) != q.charAt(i)){
                        diff++;
                        if(diff > 2)  break;
                    }

                }
                if(diff <= 2){
                    res.add(q);
                     break;
                }
            }

        }
        return res;
        
    }
}

