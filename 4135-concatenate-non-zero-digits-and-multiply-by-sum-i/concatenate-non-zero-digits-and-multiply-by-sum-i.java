class Solution {
    public long sumAndMultiply(int n) {

        if(n==0)return (long)0;

        String a=String.valueOf(n);
        String b="";
        int sum=0;

        for(int i=0;i<a.length();i++){
            if(a.charAt(i)!='0'){
                b=b+a.charAt(i);
                sum=sum+(a.charAt(i)-'0');
            }
        }

        Long p=Long.parseLong(b);
        p=p*sum;
        return p;
        
    }
}