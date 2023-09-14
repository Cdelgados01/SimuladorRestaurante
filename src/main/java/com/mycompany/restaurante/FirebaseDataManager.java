
package com.mycompany.restaurante;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class FirebaseDataManager {

    private Firestore db;

    public FirebaseDataManager(Firestore firestore) {
        this.db = firestore;
    }

    public void agregarDatos(String coleccion, String documento, Map<String, Object> datos) {
        try {
            DocumentReference docRef = db.collection(coleccion).document(documento);
            ApiFuture<WriteResult> result = docRef.set(datos);
            result.get();
            System.out.println("Datos agregados exitosamente.");
        } catch (InterruptedException | ExecutionException e) {
            System.err.println("Error al agregar datos: " + e.getMessage());
        }
    }

    public void actualizarDatos(String coleccion, String documento, Object datos) {
        try {
            DocumentReference docRef = db.collection(coleccion).document(documento);
            ApiFuture<WriteResult> result = docRef.set(datos);
            result.get();
            System.out.println("Datos actualizados exitosamente.");
        } catch (InterruptedException | ExecutionException e) {
            System.err.println("Error al actualizar datos: " + e.getMessage());
        }
    }

    public void eliminarDatos(String coleccion, String documento) {
        try {
            DocumentReference docRef = db.collection(coleccion).document(documento);
            ApiFuture<WriteResult> result = docRef.delete();
            result.get();
            System.out.println("Datos eliminados exitosamente.");
        } catch (InterruptedException | ExecutionException e) {
            System.err.println("Error al eliminar datos: " + e.getMessage());
        }
    }

    public Object obtenerDatos(String coleccion, String documento, Class<?> tipoDatos) {
        try {
            DocumentReference docRef = db.collection(coleccion).document(documento);
            ApiFuture<DocumentSnapshot> future = docRef.get();
            DocumentSnapshot document = future.get();

            if (document.exists()) {
                return document.toObject(tipoDatos);
            } else {
                System.out.println("El documento no existe.");
                return null;
            }
        } catch (InterruptedException | ExecutionException e) {
            System.err.println("Error al obtener datos: " + e.getMessage());
            return null;
        }
    }   
}