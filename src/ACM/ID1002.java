package ACM;

/**
 * Created by ZhaoTao on 2016/3/1.
 */

import java.io.PrintWriter;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
public class ID1002 {
    public static void main(String[] args) {
        PrintWriter cout = new PrintWriter(System.out, true);
        Scanner cin = new Scanner(System.in);
        int num = cin.nextInt();
        String str;
        //StringBuffer sb;
       // char tempStr;
        Map<String, Integer> map = new TreeMap<String, Integer>();

        //
        for(int i = 0;i<num;i++){
            str = cin.next();
            str = str.replace("-","");
            str = str.replaceAll("[A-C]","2").replaceAll("[D-F]","3").replaceAll("[G-I]","4")
                    .replaceAll("[J-L]","5").replaceAll("[M-O]","6").replaceAll("[P R-S]","7")
                    .replaceAll("[T-V]","8").replaceAll("[W-Y]","9");
            str = str.substring(0,3)+"-"+str.substring(3,7);
            if(map.keySet().contains(str)){
                map.put(str,map.get(str)+1);
            }else{
                map.put(str,1);
            }
        }
        //
        boolean bool = false;
        for(String st :map.keySet()){
            if(map.get(st)==1) continue;
            bool = true;
            cout.println(st+' '+map.get(st));
        }
        if(!bool){
            cout.println("No duplicates.");
        }
    }
}

//方法1
//        for(int i = 0;i<num;i++){
//            str = cin.next();
//            str = str.replace("-","");
//                sb = new StringBuffer();
//            for(int j=0;j<7;j++){
//                if(j ==3){
//                    sb.append('-');
//                }
//                tempStr = str.charAt(j);
//                switch (tempStr){
//                        case 'A':
//                        case 'B':
//                        case 'C':
//                        {tempStr='2';break;}
//                        case 'D':
//                        case 'E':
//                        case 'F':
//                        {tempStr='3';break;}
//                        case 'G':
//                        case 'H':
//                        case 'I':
//                        { tempStr='4';break;}
//                        case 'J':
//                        case 'K':
//                        case 'L':
//                        {tempStr='5';break;}
//                        case 'M':
//                        case 'N':
//                        case 'O':
//                        {tempStr='6';break;}
//                        case 'P':
//                        case 'R':
//                        case 'S':
//                        {tempStr='7';break;}
//                        case 'T':
//                        case 'U':
//                        case 'V':
//                        {tempStr='8';break;}
//                        case 'W':
//                        case 'X':
//                        case 'Y':
//                        {tempStr='9';break;}
//                }
//                sb.append(tempStr);
//            }
//            if(map.keySet().contains(sb.toString())){
//                map.put(sb.toString(),map.get(sb.toString())+1);
//            }else{
//                map.put(sb.toString(),1);
//            }
//        }

//        for(int i = 0;i<num;i++){
//             sb= new StringBuffer();
//            j = 0;
//            while (j<7){
//                tempStr = cin.nextByte();
//                System.out.println(tempStr);
//                if(tempStr=='0') {
//                    j++;
//                }
//                else  if(tempStr=='A'||tempStr=='B'||tempStr=='C'||tempStr=='2'){
//                    tempStr='2'; j++;
//                }else  if(tempStr=='D'||tempStr=='E'||tempStr=='F'||tempStr=='3'){
//                    tempStr='3';j++;
//                }else  if(tempStr=='G'||tempStr=='H'||tempStr=='I'||tempStr=='4'){
//                    tempStr='4';j++;
//                }else  if(tempStr=='J'||tempStr=='K'||tempStr=='L'||tempStr=='5'){
//                    tempStr='5';j++;
//                }else  if(tempStr=='M'||tempStr=='N'||tempStr=='O'||tempStr=='6'){
//                    tempStr='6';j++;
//                }else  if(tempStr=='P'||tempStr=='R'||tempStr=='S'||tempStr=='7'){
//                    tempStr='7';j++;
//                }else  if(tempStr=='T'||tempStr=='U'||tempStr=='V'||tempStr=='8'){
//                    tempStr='8';j++;
//                }else  if(tempStr=='W'||tempStr=='Y'||tempStr=='Z'||tempStr=='9'){
//                    tempStr='9';j++;
//                }else{
//                    tempStr = '@';
//                }
//                sb.append(tempStr);
//            }
//            System.out.println(sb);
//        }
