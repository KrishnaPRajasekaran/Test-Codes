
	class Outer {
		// Simple nested inner class
		private int i=5;
		void test(){
		
		class Inner {
			public void show() {
				System.out.println("In a nested class method"+ i);
			}
		}
	new Inner().show();
		}
		}
		class OuterInner {
		public static void main(String[] args) {
			Outer in = new Outer();
			in.test();
		}
		}

