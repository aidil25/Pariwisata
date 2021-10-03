/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.aidil.model;

/**
 *
 * @author Aidil
 */
public class Transportasi {
    private String id_transportasi,nama_kendaraan,id_jenis_transportasi,status,tarif_transportasi;

    public String getId_transportasi() {
        return id_transportasi;
    }

    public void setId_transportasi(String id_transportasi) {
        this.id_transportasi = id_transportasi;
    }

    public String getNama_kendaraan() {
        return nama_kendaraan;
    }

    public void setNama_kendaraan(String nama_kendaraan) {
        this.nama_kendaraan = nama_kendaraan;
    }

    public String getId_jenis_transportasi() {
        return id_jenis_transportasi;
    }

    public void setId_jenis_transportasi(String id_jenis_transportasi) {
        this.id_jenis_transportasi = id_jenis_transportasi;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTarif_transportasi() {
        return tarif_transportasi;
    }

    public void setTarif_transportasi(String tarif_transportasi) {
        this.tarif_transportasi = tarif_transportasi;
    }
    
    
}
