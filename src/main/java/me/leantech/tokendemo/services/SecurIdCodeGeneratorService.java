package me.leantech.tokendemo.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.stoken.LibStoken;

import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@Service
@AllArgsConstructor
public class SecurIdCodeGeneratorService {

    public String generateCode(String rsaToken) {
        var lib = new LibStoken();
        var result = lib.importString(rsaToken);
        var seed = lib.decryptSeed(null, null);
        var info = lib.getInfo();
        System.out.println("SN: " + info.serial);
        System.out.println("Interval: " + info.interval);
        Date d = new Date(info.unixExpDate * 1000);
        System.out.println("Exp: " + new SimpleDateFormat("yyyy-MM-dd").format(d));

        lib.checkDevID(null);
        lib.checkPIN(null);

        String code = lib.computeTokencode(0, null);

        lib.destroy();

        return code;
    }
}
