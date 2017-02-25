package edu.sjsu.java.anoop;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Stack;
import java.util.Comparator;


public class Problems 
{
    public static void removeDup1(SingleLinkedList list)
    {
        SingleLinkedList.Node previous = null;
        SingleLinkedList.Node current = list.getHead();
        Hashtable table = new Hashtable();
        while(current != null)
        {
            if(!table.containsKey(current.data))
            {
                table.put(current.data, true);
                previous = current;
            }
            else
            {
                previous.next = current.next;
            }
            current = current.next;
        }
    }
    
    public static void removeDup2(SingleLinkedList list)
    {
        SingleLinkedList.Node slow = list.getHead();
        while(slow != null)
        {
            SingleLinkedList.Node fast = slow;
            while(fast != null && fast.next != null)
                if(slow.data.equals(fast.next.data))
                    fast.next = fast.next.next;
                fast = fast.next;
            slow = slow.next;
        }
    }
    
    public static int nthToLast(SingleLinkedList.Node node, int k)
    {
        //SingleLinkedList.Node slow = list.getHead();
        if(node == null) return 0;
        int i = nthToLast(node.next, k) + 1;
        if(i == k)
            System.out.println(node.data);
        return i;
    }
    
    public static boolean isPermutation(String s, String t)
    {
        if(s.length() != t.length())
            return false;
        int letters[] = new int[256];
        for(char c : s.toCharArray())
            letters[c]++;
        for(int i=0;i<t.length();i++)
            if(--letters[(int)t.charAt(i)] < 0)
                return false;
        return true;
    }
    
    public static String sortChars(String s)
    {
        char[] content = s.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }    
    
    public static void sortAnagram(String[] str)
    {
        Map<String, ArrayList<String>> lst = new HashMap<String, ArrayList<String>>();
        for(String s : str)
        {
            String key = sortChars(s);
            if(!lst.containsKey(key))
                lst.put(key, new ArrayList());
            lst.get(key).add(s);
        }
        
        for(String key : lst.keySet())
            for(String s : lst.get(key))
                System.out.print(s + ", ");
    }
    
    public static int search(int[] a, int left, int right, int d)
    {
        if(left > right)
            return -1;
        int mid = (right + left) / 2;
        if(a[mid] == d)
            return d;
        
        if(a[left] < a[mid])
        {
            if(d >= a[left] && d <= a[mid])
                return search(a, left, mid-1, d);
            else
                return search(a, mid+1, right, d);
        }
        else if(a[mid] < a[left])
        {
            if(d >= a[mid] && d <= a[right])
                return search(a, mid+1, right, d);
            else
                return search(a, left, mid-1, d);
        }
        else if(a[mid] == a[left])
        {
            if(a[mid] != a[right])
                return search(a, mid+1, right, d);
            else
            {
                if(search(a, left, mid-1, d) == -1)
                    return search(a, mid+1, right, d);
            }
        }
        return -1;
    }
    
    public static int hasWon(int[][] board)
    {
        int n = board.length;
        int row = 0;
        int col = 0;
        
        for(row=0;row<n;row++)
        {
            for(col=1;col<n;col++)
                if(board[row][col] != board[row][col-1]) break;
            if(col == n) return board[row][0];
        }

        for(col=0;col<n;col++)
        {
            for(row=1;row<n;row++)
                if(board[row][col] != board[row-1][col]) break;
            if(row == n) return board[0][col];
        }

        if(board[0][0] != -1)
        {
            for(row=1;row<n;row++)
                if(board[row][row] != board[row-1][row-1]) break;
            if(row == n) return board[0][0];
        }

        if(board[n-1][0] != -1)
        {
            for(row=n-1,col=0;row>0&&col<n;row--,col++)
                if(board[row-1][col+1] != board[row][col])
                {
                    break;
                }
            if(row == 0) return board[n-1][0];
        }
        return -1;
    }
    
    class StackWithMin extends Stack<Integer>
    {
        Stack<Integer> stk = new Stack<Integer>();

        public void push(int val)
        {
            if(val < min())
                stk.push(val);
            super.push(val);
        }

        public Integer pop()
        {
            int val = super.pop();
            if(val == min())
                stk.pop();
            return val;
        }

        public int min()
        {
            if(stk.empty())
                return Integer.MAX_VALUE;
            return stk.peek();
        }
    }    
    
    public static int countFactZeros(int num)
    {
        int count = 0;
        if(num < 0)
            return -1;
        for(int i=5;num/i>0;i*=5)
        {
            count += num/i;
        }
        return count;
    }
    
    public static Set<String> generateParens1(int count)
    {
        Set<String> result = new HashSet<String>();
        if(count == 0)
        {
            result.add("");
            return result;
        }
        Set<String> result1 = generateParens1(count-1);
        
        for(String str : result1)
        {
            for(int i=0;i<str.length();i++)
                if(str.charAt(i) == '(')
                    result.add(str.substring(0, i+1) + "()" + str.substring(i+1));
            if(!result.contains("()"+str))
                result.add("()"+str);
        }
        return result;
    }
    
    public static int magicIndex1(int a[], int left, int right)
    {
        if(left < 0 || right >= a.length || left > right) 
            return -1;
        int mid = (left + right) / 2;
        if(a[mid] == mid) return mid;
        else if(a[mid] < mid)
            return magicIndex1(a, mid+1, right);
        else
            return magicIndex1(a, left, mid-1);
    }

    public static int magicIndex2(int a[], int left, int right)
    {
        if(left < 0 || right >= a.length || left > right) 
            return -1;
        int mid = (left + right) / 2;
        if(a[mid] == mid)
            return mid;
        int leftIndex = Math.min(mid-1, a[mid]);
        int l = magicIndex2(a, left, leftIndex);
        if(l >= 0)
            return l;
        int rightIndex = Math.max(mid+1, a[mid]);
        l = magicIndex2(a, rightIndex, right);
        return l;
    }

    public static int makeChange(int n, int denom)
    {
        int nextDenom = 0;
        switch(denom)
        {
            case 25: nextDenom = 10;break;
            case 10: nextDenom = 5;break;
            case 5: nextDenom = 1;break;
            case 1: return 1;
        }
        int ways = 0;
        for(int i=0;i*denom<=n;i++)
        {
            ways += makeChange(100-i*denom, nextDenom);
        }
        return ways;
    }
    
    public static void generateParens2(ArrayList<String> lst, char[] s, int leftParen, int rightParen, int index)
    {
        if(leftParen < 0 || rightParen < leftParen)
            return;
        if(leftParen == 0 && rightParen == 0)
            lst.add(String.valueOf(s));
        if(leftParen > 0)
        {
            s[index] = '(';
            generateParens2(lst, s, leftParen-1, rightParen, index+1);
        }
        if(rightParen > leftParen)
        {
            s[index] = ')';
            generateParens2(lst, s, leftParen, rightParen-1, index+1);
        }
    }    
    // 1 2 3
    // 4 5 6
    // 7 8 9
    public static void rotateArray(int[][] a, int n)
    {
        for(int layer=0;layer<n/2;layer++)
        {
            int first = layer;
            int last = n - 1 - layer;
            for(int i=first;i<last;i++)
            {
                int offset = i - first;
                int top = a[first][i];
                a[first][i] = a[last-offset][first];
                a[last-offset][first] = a[last][last-offset];
                a[last][last-offset] = a[i][last];
                a[i][last] = top;
            }
        }
    }
   
    public static int[] pickRandomly(int[] a, int n)
    {
        int[] s = new int[n];
        for(int i=0;i<n;i++)
        {
            int index = i + (int)(Math.random() * (a.length-1-i+1));
            s[i] = a[index];
            a[index] = a[i];
        }
        return s;
    }
    
    public static int countNumberOf2s(int num)
    {
        int count = 0;
        for(int i=2;i<=num;i++)
        {
            int n = i;
            while(n > 0)
            {
                if(n % 10 == 2)
                    count++;
                n = n / 10;
            }
        }
        return count;
    }
    
    public static long countWays(int n, Map<Integer, Long> m)
    {
        if(n < 0) return 0;
        if(n == 0) return 1;
        if(m.containsKey(n))
            return m.get(n);
        m.put(n, (countWays(n-1, m) + countWays(n-2, m) + countWays(n-3, m)));
        return m.get(n);
    }

    public static long fibonacci(int num, Map<Integer, Long> m)
    {
        if(num <= 1) return num;
        if(m.containsKey(num))
            return m.get(num);
        m.put(num, fibonacci(num-1, m) + fibonacci(num-2, m));
        return m.get(num);
    }

    public static int shortest(String[] words, String word1, String word2)
    {
        int pos1 = -1;
        int pos2 = -1;
        int minDistance = Integer.MAX_VALUE;
        
        for(int i=0;i<words.length;i++)
        {
            if(words[i].equals(word1))
            {
                pos1 = i;
                int distance = pos1 - pos2;
                if(pos2 >= 0 && minDistance > distance)
                    minDistance = distance;
            }
            else if(words[i].equals(word2))
            {
                pos2 = i;
                int distance = pos2 - pos1;
                if(pos1 >= 0 && minDistance > distance)
                    minDistance = distance;
            }
        }
        return minDistance;
    }
    
    public static String printLongestWord(String[] arr)
    {
        Map<String, Boolean> map = new HashMap<String, Boolean>();
        for(String s : arr)
            map.put(s, Boolean.TRUE);
        Comparator comp = new Comparator()
        {
            @Override
            public int compare(Object o1, Object o2) {
                return ((String)o2).length() - ((String)o1).length();
            }
        };
        Arrays.sort(arr, comp);
        for(String str : arr)
            if(canBuildWord(str, true, map))
                return str;
        return "";
    }
    
    public static boolean canBuildWord(String str, boolean isOriginalWord, Map<String, Boolean> map)
    {
        if(map.containsKey(str) && !isOriginalWord)
            return map.get(str);
        
        for(int i=1;i<str.length();i++)
        {
            String left = str.substring(0, i);
            String right = str.substring(i, str.length());
            if(map.containsKey(left) && map.get(left) && canBuildWord(right, false, map))
                return true;
        }
        //map.put(str, false);
        return false;
    }
    
    public static void main(String[] args)
    {// eq, ual, la, equal
      int a=0,b=1;

    for (int i=0;i<10;i++){
      System.out.println(a);
      a=a+b;
      b=a-b;
    }
    }

    
}



