package com.Google;

import java.util.ArrayList;

public class UniqueEmailAddress {

	public static String getValidName(String name, char check) {
        int n = name.length();
        StringBuilder s = new StringBuilder("");
        if(check == 'L') {
            for(int i=0; i<n;i++){
                char ch = name.charAt(i);
                if(ch == '+') return s.toString();
                else if(ch != '.') s.append(ch);;
            }
        }
        return s.toString();
    }
    public static int numUniqueEmails(String[] emails) {
        int n = emails.length;
        ArrayList<String> output = new ArrayList<String>();
        if(n ==0) return 0;
        for(String email: emails) {
            String[] emailSplit = email.split("@");
            String localName= getValidName(emailSplit[0], 'L');
            if(localName.length() > 0) {
                String str = localName+"@"+emailSplit[1];
                if(!output.contains(str)) output.add(str);
            }
        }
        return output.size();
        
    }
	public static void main(String[] args) {
		String[] emails = {"fg.r.u.uzj+o.pw@kziczvh.com",
		                    "r.cyo.g+d.h+b.ja@tgsg.z.com",
		                    "fg.r.u.uzj+o.f.d@kziczvh.com",
		                    "r.cyo.g+ng.r.iq@tgsg.z.com",
		                    "fg.r.u.uzj+lp.k@kziczvh.com",
		                    "r.cyo.g+n.h.e+n.g@tgsg.z.com",
		                    "fg.r.u.uzj+k+p.j@kziczvh.com",
		                    "fg.r.u.uzj+w.y+b@kziczvh.com",
		                    "r.cyo.g+x+d.c+f.t@tgsg.z.com",
		                    "r.cyo.g+x+t.y.l.i@tgsg.z.com",
		                    "r.cyo.g+brxxi@tgsg.z.com",
		                    "r.cyo.g+z+dr.k.u@tgsg.z.com",
		                    "r.cyo.g+d+l.c.n+g@tgsg.z.com",
		                    "fg.r.u.uzj+vq.o@kziczvh.com",
		                    "fg.r.u.uzj+uzq@kziczvh.com",
		                    "fg.r.u.uzj+mvz@kziczvh.com",
		                    "fg.r.u.uzj+taj@kziczvh.com",
		                    "fg.r.u.uzj+fek@kziczvh.com"};
		System.out.println(numUniqueEmails(emails));

	}

}
