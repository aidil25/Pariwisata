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
public class Pengembalian {
    String id_pengembalian,id_pemesanan,tanggal_perjalanan,tanggal_kembali,terlambat,denda;

    public String getId_pengembalian() {
        return id_pengembalian;
    }

    public void setId_pengembalian(String id_pengembalian) {
        this.id_pengembalian = id_pengembalian;
    }

    public String getId_pemesanan() {
        return id_pemesanan;
    }

    public void setId_pemesanan(String id_pemesanan) {
        this.id_pemesanan = id_pemesanan;
    }

    public String getTanggal_perjalanan() {
        return tanggal_perjalanan;
    }

    public void setTanggal_perjalanan(String tanggal_perjalanan) {
        this.tanggal_perjalanan = tanggal_perjalanan;
    }

    public String getTanggal_kembali() {
        return tanggal_kembali;
    }

    public void setTanggal_kembali(String tanggal_kembali) {
        this.tanggal_kembali = tanggal_kembali;
    }

    public String getTerlambat() {
        return terlambat;
    }

    public void setTerlambat(String terlambat) {
        this.terlambat = terlambat;
    }

    public String getDenda() {
        return denda;
    }

    public void setDenda(String denda) {
        this.denda = denda;
    }
    
    
}
