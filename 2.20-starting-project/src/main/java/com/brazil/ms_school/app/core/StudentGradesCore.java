package com.brazil.ms_school.app.core;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

import static java.math.BigDecimal.valueOf;
import static java.math.RoundingMode.HALF_UP;

@NoArgsConstructor
@ToString
@Getter
@Setter
@Component
public class StudentGradesCore {

    List<Double> mathGradeResults;
    /*
     * CAN HAVE MULTIPLE DIFFERENT TYPES OF GRADES
     * FOR 2.x WE WILL ONLY HAVE A MATH GRADE
     *  */

    public StudentGradesCore(List<Double> mathGradeResults) {
        this.mathGradeResults = mathGradeResults;
        /*
        Add other subject grades here in future lessons
        */
    }

        /*
        Add other subject grades here in future lessons
        */

    public double addGradeResultsForSingleClass(List<Double> grades) {
        double result = 0;
        for (double i : grades) {
            result += i;
        }
        return result;
    }

    public double findGradePointAverage(List<Double> grades) {
        int lengthOfGrades = grades.size();
        double sum = addGradeResultsForSingleClass(grades);
        double result = sum / lengthOfGrades;

        // add a round function
        BigDecimal resultRound = valueOf(result);
        resultRound = resultRound.setScale(2, HALF_UP);
        return resultRound.doubleValue();
    }

    public Boolean isGradeGreater(double gradeOne, double gradeTwo) {
        if (gradeOne > gradeTwo) {
            return true;
        }
        return false;
    }

    public Object checkNull(Object obj) {
        if (obj != null) {
            return obj;
        }
        return null;
    }

}
