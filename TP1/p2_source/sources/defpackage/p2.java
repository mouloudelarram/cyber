package defpackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/* loaded from: p2_mod.jar:p2.class */
public class p2 {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Exception] */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.net.ServerSocket] */
    /* JADX WARN: Type inference failed for: r0v15, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v24 */
    /* JADX WARN: Type inference failed for: r0v25, types: [java.net.Socket] */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.net.ServerSocket] */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.io.PrintStream] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.lang.Exception] */
    /* JADX WARN: Type inference failed for: r0v9 */
    public static void main(String[] strArr) {
        ?? r0;
        try {
            r0 = new ServerSocket(12345);
            try {
                r0 = System.out;
                r0.println("Serveur en attente de connexions...");
                while (true) {
                    try {
                        Socket accept = r0.accept();
                        try {
                            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(accept.getInputStream()));
                            try {
                                bufferedReader.readLine();
                                System.out.println("Message reçu");
                                bufferedReader.close();
                                r0 = accept;
                                if (r0 != 0) {
                                    r0 = accept;
                                    r0.close();
                                }
                            } catch (Throwable th) {
                                try {
                                    bufferedReader.close();
                                } catch (Throwable th2) {
                                    th.addSuppressed(th2);
                                }
                                throw th;
                            }
                        } catch (Throwable th3) {
                            if (accept != null) {
                                try {
                                    accept.close();
                                } catch (Throwable th4) {
                                    th3.addSuppressed(th4);
                                }
                            }
                            r0 = th3;
                            throw r0;
                        }
                    } catch (Exception e) {
                        r0.printStackTrace();
                    }
                }
            } finally {
            }
        } catch (Exception e2) {
            r0.printStackTrace();
        }
    }
}
