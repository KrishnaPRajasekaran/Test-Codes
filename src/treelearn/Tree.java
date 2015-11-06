package treelearn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

class Node
{
int val;
Node left;
Node right;
Node(int val)
{
this.val=val;
left=null;
right=null;
}
}

class Tree
{
Node root;
void insert(int val)
{
if(root==null)
root=new Node(val);
else
insert(root,val);
}
void insert(Node n,int val){
if(val<n.val)
{
if(n.left==null)
n.left=new Node(val);
else
insert(n.left,val);
}else
{
if(n.right==null)
n.right=new Node(val);
else
insert(n.right,val);
}

}

void inorder(Node d){
if(d!=null)
{
inorder(d.left);
System.out.print(d.val+" ");
inorder(d.right);

}
}

void preorder(Node d){
if(d!=null){
System.out.print(d.val+" ");
preorder(d.left);
preorder(d.right);

}}

void postorder(Node d){
if(d!=null){

postorder(d.left);
postorder(d.right);
System.out.print(d.val+" ");
}
}

void levelorder(Node d){
	Queue<Node> q=new ArrayDeque<Node>();
	q.add(root);
ArrayList<Integer> levelcount=new ArrayList<Integer>();
int loopcount=0;
int c=1;
levelcount.add(1);
	while(!q.isEmpty()){
		Node v=q.poll();
	
System.out.print(v.val+" ");
loopcount++;
if(loopcount==levelcount.get(0)){
	System.out.println();
	levelcount.remove(0);
}
	if(v.left!=null){
		q.add(v.left);
		c++;}
	if(v.right!=null){
		q.add(v.right);
		c++;
	}
	
	levelcount.add(c);
	}
	
}

void delete(int val)
{
	root=delete(root,val);
}
Node delete(Node r,int val){
if(r.val==val)
{
Node left=r.left;
Node right=r.right;
if(left==null && right==null){
r=null;
return null;
}
if(right==null)
{
r=left;
return r;
}
if(left==null){
r=right;
return r;
}

Node p;
p=right;
while(p.left!=null)
p=p.left;
p.left=left;
return right;
}
if(val<r.val)
{
Node n=delete(r.left,val);
r.left=n;
}
if(val>r.val)
{
Node n=delete(r.right,val);
r.right=n;

}
return r;
}

public static void main(String args[])
{
Tree t=new Tree();
t.insert(5);
t.insert(15);
t.insert(51);
t.insert(25);
t.insert(3);
t.insert(1);
t.inorder(t.root);
System.out.println();
t.preorder(t.root);
System.out.println();
t.postorder(t.root);
System.out.println();
t.levelorder(t.root);
System.out.println();

t.delete(51);
t.inorder(t.root);
System.out.println();
t.levelorder(t.root);
System.out.println();

}

}

