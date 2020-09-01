class Solution {
    public double[] intersection(int[] start1,int[] end1,int[] start2,int[] end2){
        if(start1[0]==end1[0]||start2[0]==end2[0]){
            if(start1[0]!=end1[0]){
                int[] temps=start2;
                int[] tempe=end2;
                start2=start1;
                end2=end1;
                start1=temps;
                end1=tempe;
            }
            if((start2[0]-start1[0])*(end2[0]-end1[0])>0){
                double[] res=new double[0];
                return res;
            }else if((start2[0]-start1[0])*(end2[0]-end1[0])==0){
                int s1,e1,s2,e2;
                if(end2[1]>start2[1]){
                    s2=start2[1];
                    e2=end2[1];
                }else{
                    s2=end2[1];
                    e2=start2[1];
                }
                if(end1[1]>start1[1]){
                    s1=start1[1];
                    e1=end1[1];
                }else{
                    s1=end1[1];
                    e1=start1[1];
                }
                if(s1<s2){
                    if(s2<=e1){
                        double[] res=new double[2];
                        res[0]=start1[0];
                        res[1]=s2;
                        return res;
                    }else{
                        double[] res=new double[0];
                        return res;
                    }
                }else if(s1==s2){
                    double[] res=new double[2];
                    res[0]=start1[0];
                    res[1]=s2;
                    return res;
                }else{
                    if(s1<=e2){
                        double[] res=new double[2];
                        res[0]=start1[0];
                        res[1]=s1;
                        return res;
                    }else{
                        double[] res=new double[0];
                        return res;
                    }
                }
            }else{
                double y=(double)((double)(end2[1]-start2[1])/(double)(end2[0]-start2[0])*(double)(start1[0]-start2[0])+(double)start2[1]);
                if((y-start1[1])*(y-end1[1])<=0){
                    double[] res=new double[2];
                    res[0]=start1[0];
                    res[1]=y;
                    return res;
                }
            }
        }
        double[] res=new double[0];
        return res;
    }
}