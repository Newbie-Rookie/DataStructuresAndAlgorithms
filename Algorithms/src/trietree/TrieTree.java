package trietree;


/**
 *  前缀树
 */
public class TrieTree {

    public static void main(String[] args) {

    }

    /**
     * 前缀树节点
     */
    public static class TrieNode{
        // 节点经过几次
        public int pass;
        // 多少字符串以该节点为结尾
        public int end;
        // 节点的下一层节点
        public TrieNode[] nexts;

        public TrieNode(){
            pass = 0;
            end = 0;
            // 如果字符串只有26个小写/大写字母
            // 如果字符特别多，选用哈希表HashMap<Character, Node> nexts
            nexts = new TrieNode[26];
        }
    }

    /**
     * 前缀树
     */
    public static class Trie{
        public TrieNode root;

        public Trie(){
            root = new TrieNode();
        }

        /**
         * 字符串插入（沿途节点pass+1，最后节点end+1）
         * @param word
         */
        public void insert(String word){
            if(word == null){
                return;
            }
            // 移动节点
            TrieNode node = root;
            // 节点经过次数+1
            node.pass++;
            // 遍历整个字符串
            for(int i = 0;i < word.length();++i){
                char c = word.charAt(i);
                // 如果该字符对应位置没有节点则新建
                if(node.nexts[c - 'a'] == null){
                    node.nexts[c - 'a'] = new TrieNode();
                }
                node = node.nexts[c - 'a'];
                // 节点经过次数+1
                node.pass++;
            }
            node.end++;
        }

        /**
         * 字符串删除（沿途节点pass-1，最后节点end-1）
         * @param word
         */
        public void delete(String word){
            // 确定树中确实加入过word
            if(search(word) != 0){
                // 移动节点
                TrieNode node = root;
                // 节点经过次数-1
                node.pass--;
                // 遍历整个字符串
                for(int i = 0;i < word.length();++i){
                    char c = word.charAt(i);
                    // 如果该字符对应位置pass-1，如果pass为0，无需再遍历
                    if(--node.nexts[c - 'a'].pass == 0){
                        node.nexts[c - 'a'] = null;
                        return;
                    }
                    node = node.nexts[c - 'a'];
                }
                node.end--;
            }
        }

        /**
         * 字符串出现次数（最后节点的end）
         * @param word
         * @return
         */
        public int search(String word){
            if(word == null){
                return 0;
            }
            // 移动节点
            TrieNode node = root;
            // 遍历整个字符串
            for(int i = 0;i < word.length();++i){
                char c = word.charAt(i);
                // 如果该字符对应位置没有节点则字符串不存在
                if(node.nexts[c - 'a'] == null){
                    return 0;
                }
                node = node.nexts[c - 'a'];
            }
            return node.end;
        }

        /**
         * 有多少个字符串以该字符串为前缀（最后节点的pass）
         * @param pre
         * @return
         */
        public int prefixNumber(String pre){
            if(pre == null){
                return 0;
            }
            // 移动节点
            TrieNode node = root;
            // 遍历整个字符串
            for(int i = 0;i < pre.length();++i){
                char c = pre.charAt(i);
                if(node.nexts[c - 'a'] == null){
                    return 0;
                }
                // 走字符的对应位置
                node = node.nexts[c - 'a'];
            }
            return node.pass;
        }
    }
}