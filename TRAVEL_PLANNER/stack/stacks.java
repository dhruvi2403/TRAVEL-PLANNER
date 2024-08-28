package stack;
import javax.swing.*;

public class stacks {
    public JFrame[] s;
    int cap=15, top;

    public stacks() {
        top = -1;
        s = new JFrame[cap];
    }

    public void s_push(JFrame x){
        if(top>=cap-1)
        {
            System.out.println("overflow");
        }
        else{
            top++;
            s[top]=x;
        }
    }

    public JFrame s_pop(){
        if(top==-1)
        {
            System.out.println("underflow");
            return null;
        }
        else{
            System.out.println(s[top]+"is deleted");
            top--;
            return s[top];
        }
    }
    public boolean s_isEmpty(){
        return top==-1;
    }
    public void s_display(){
        if(top==-1)
        {
            System.out.println("underflow");
        }
        else{
            System.out.println("current stack is as follows:");
            for(int i=top;i>=0;i--)
            {
                System.out.println(s[i].getTitle());
            }
        }
    }
    
}
