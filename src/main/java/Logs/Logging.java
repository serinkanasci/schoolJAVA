package Logs;

import org.aspectj.lang.JoinPoint;

public class Logging {
    public void beforeMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().toShortString();
        Object[] args = joinPoint.getArgs();

        StringBuilder builder = new StringBuilder();
        builder.append("Methode ");
        builder.append(methodName);
        builder.append(" invoquee avec les parametres : ");
        for(Object o : args){
            builder.append(o);
            builder.append(" - ");
        }
        System.out.println(builder.toString());
    }
    public void afterMethod(JoinPoint joinPoint, Object result){
        String methodName = joinPoint.getSignature().toShortString();
        System.out.println("Methode " + methodName + " a produit le resultat " + result);
    }
}
