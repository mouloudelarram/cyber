package defpackage;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/* loaded from: p1_mod.jar:p1.class */
public class p1 {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Exception] */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.net.Socket] */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.net.Socket] */
    public static void main(String[] strArr) {
        ?? r0 = "2cb4b1431b84ec15d35ed83bb927e27e8967d75f4bcd9cc4b25c8d879ae23e18";
        try {
            r0 = new Socket("127.0.0.1", 12345);
            try {
                OutputStream outputStream = r0.getOutputStream();
                try {
                    PrintWriter printWriter = new PrintWriter(outputStream, true);
                    try {
                        printWriter.println("2cb4b1431b84ec15d35ed83bb927e27e8967d75f4bcd9cc4b25c8d879ae23e18");
                        System.out.println("Message envoyé");
                        printWriter.close();
                        if (outputStream != null) {
                            outputStream.close();
                        }
                        r0.close();
                    } catch (Throwable th) {
                        try {
                            printWriter.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (Throwable th4) {
                            th3.addSuppressed(th4);
                        }
                    }
                    throw th3;
                }
            } finally {
            }
        } catch (Exception e) {
            r0.printStackTrace();
        }
    }
}
