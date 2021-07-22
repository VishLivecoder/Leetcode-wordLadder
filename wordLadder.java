class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        HashSet<String> hash=new HashSet<String>();
        for(String word: wordList){
            hash.add(word);
        }
        if(hash.contains(endWord)==false){
            return 0;
        }
        // we are using a BFS for this solution. this is basically like moving from one word to its adjacent word and incrementing the level untill you find the end word.
        
        Queue<String> queue=new LinkedList<String>();
        queue.add(beginWord);
        int level=1;
        while(queue.isEmpty()==false){
            int size=queue.size();
            for(int i=0;i<size;i++){
                String currentWord=queue.poll();
                char[] considered_word=currentWord.toCharArray();
                for(int j=0;j<considered_word.length;j++){
                    char c=considered_word[j];
                    for(char k='a';k<='z';k++){
                        if(k==c) continue;
                        
                        considered_word[j]=k;
                        String temp=String.valueOf(considered_word);
                        if(temp.equals(endWord)) return level+1;
                        if(hash.contains(temp)){
                            queue.add(temp);
                            hash.remove(temp);
                            
                        }
                    }
                    considered_word[j]=c;
                }
                
                
            }
            level++;
            
        }
        return 0;
        
    }
}
