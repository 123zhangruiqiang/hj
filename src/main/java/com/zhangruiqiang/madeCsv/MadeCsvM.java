
package com.zhangruiqiang.madeCsv;

import com.zhangruiqiang.madeCsv.util.MadePlatFormNo;

import java.util.List;

public class MadeCsvM {
    public static void main(String[] args) {
        List<String> platfromnoList= MadePlatFormNo.getSinglePlatfromNo(10);
        MadePlatForm.doPlatFormInfo(10);
        MadeProject.doProjectInfo(10);

       MadeInvertinfo.doInvertInfo(10);
       MadeLoanInfo.doLoanInfo(10);
       // MadeBrossor.doBrossorInfo(10);

       // MadeReyp.doReypInfo(10);

    }
}

