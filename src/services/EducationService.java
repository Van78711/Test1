package services;

import program.EducationalProgram;

public class EducationService {

    public static void changeHours(EducationalProgram p, String subject, int v){
        int i = ingex(p, subject);
        if(i == -1)
            return;
        if(p.getSubjects().get(i).getCount() + v == 0)
            p.getSubjects().remove(i);
        else{
            p.getSubjects().get(i).setCount(p.getSubjects().get(i).getCount()+v);
        }
    }
    public static int ingex(EducationalProgram p, String subject){
        for (int i = 0; i < p.getSubjects().size(); i++) {
            if(subject.equals(p.getSubjects().get(i).getTitle()))
                return i;
        }
        return -1;
    }
}
