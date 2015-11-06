package algorithms;
class Val
{
	String s;
	int i;
	Val(String s,int i){
		this.s=s;
		this.i=i;
	}
	Val add(Val v)
	{
		s=s.concat(v.s);
		i=i+v.i;
		return this;
	}
}
public class Lcs {
	static Val print(String a, String b) {
		if (a.length() == 0 || b.length() == 0){
			
			return new Val("",0) ;
		}
		if (a.substring(0, 1).equals(b.substring(0, 1))) {
			//c = c + a.substring(0, 1);
		
			return new Val(a.substring(0,1),1).add(print(a.substring(1), b.substring(1)));
		} else {
			
			if (print(a, b.substring(1)).i > print(a.substring(1), b).i) {
		
				return print(a, b.substring(1));
			} else {
				
return print(a.substring(1),b);
			}
			
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(print("krishna", "nishaa").s);
	}

}
