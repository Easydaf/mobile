data class BarangdiGudang(val id: Int, var nama: String, var jumlah: Int, var harga: Int, var kategori: String)

class GudangBarangHalal {
    val dataBarang = mutableListOf<BarangdiGudang>()

    fun tambahBarang(id: Int, nama: String, jumlah: Int, harga: Int, kategori: String) {
        dataBarang.add(BarangdiGudang(id, nama, jumlah, harga, kategori))
        println("Barang $nama berhasil ditambahkan")
    }

    fun lihatBarang() {
        if (dataBarang.isEmpty()) {
            println("Gudang kosong")
        } else {
            dataBarang.forEach {
                println("ID:${it.id}, Nama:${it.nama}, Jumlah:${it.jumlah}, Harga:${it.harga}, Kategori:${it.kategori}")
            }
        }
    }

    fun editBarang(id: Int, nama: String, jumlah: Int, harga: Int, kategori: String) {
        val barang = dataBarang.find { it.id == id } ?.apply{
            this.nama = nama
            this.jumlah = jumlah
            this.harga = harga
            this.kategori = kategori
            println("Barang dengan id: ${this.id} berhasil diubah")
        } ?: run {
            println("Barang tidak ditemukan")
        }
    }

    fun hapusBarang(id: Int) {
        val yangmauDihapus = dataBarang.find { it.id == id } ?.also { dataBarang.remove(it)
            println("barang ${it.nama} berhasil dihapus")
        } ?: run {
            println("Barang tidak ditemukan")}
    }
}

fun main() {
    val gudang = GudangBarangHalal()

    while (true) {
        println("***=== Menu Gudang ===***")
        println("1. Tambah Barang")
        println("2. Lihat Barang")
        println("3. Edit Barang")
        println("4. Hapus Barang")
        println("5. Keluar")
        print("Pilih Menu: ")

        when (readLine()?.toIntOrNull()) {
            1 -> {
                var id: Int
                do {
                    print("Masukkan ID Barang: ")
                    val input = readLine()?.toIntOrNull()
                    if (input != null) {
                        id = input
                        break
                    } else {
                        println("Int woi")
                    }
                } while (true)

                print("Masukkan Nama Barang: ")
                val nama = readLine().orEmpty()

                var jumlah: Int
                do {
                    print("Masukkan Jumlah Barang: ")
                    val input = readLine()?.toIntOrNull()
                    if (input != null) {
                        jumlah = input
                        break
                    } else {
                        println("Int woi")
                    }
                } while (true)

                var harga: Int
                do {
                    print("Masukkan Harga Barang: ")
                    val input = readLine()?.toIntOrNull()
                    if (input != null) {
                        harga = input
                        break
                    } else {
                        println("Int woi")
                    }
                } while (true)

                print("Masukkan Kategori Barang: ")
                val kategori = readLine().orEmpty()

                gudang.tambahBarang(id, nama, jumlah, harga, kategori)
            }
            2 -> gudang.lihatBarang()
            3 -> {
                print("Masukkan ID yang ingin diubah: ")
                val id = readLine()?.toIntOrNull()
                if (id != null) {
                    var namabaru: String
                    var jumlahbaru: Int
                    var hargabaru: Int
                    var kategoribaru: String
                    do {
                        print("masukkan nama baru: ")
                        namabaru = readLine().orEmpty()
                        if (namabaru.isNotEmpty()) {
                            break
                        } else {
                            println("isi dong")
                        }
                    }while (true)
                    do {
                        print("masukkan jumlah baru: ")
                        jumlahbaru = readln().toIntOrNull() ?: 0
                        if (jumlahbaru != 0) {
                            break
                        } else {
                            println("int woi")
                        }
                    }while (true)
                    do {
                        print("masukkan harga baru: ")
                        hargabaru = readln().toIntOrNull() ?: 0
                        if (hargabaru != 0) {
                            break
                        } else {
                            println("int woi")
                        }
                    }while (true)
                    do {
                        print("masukkan kategori baru: ")
                        kategoribaru = readLine().orEmpty()
                        if (kategoribaru.isNotEmpty()) {
                            break
                        } else {
                            println("isi dong")
                        }
                    }while (true)

                    gudang.editBarang(id, namabaru, jumlahbaru, hargabaru, kategoribaru)
                } else {
                    println("ID barang tidak ada")
                }
            }
            4 -> {
                println("Masukkan ID barang yang mau dihapus: ")
                val id = readLine()?.toIntOrNull()
                if (id != null) {
                    gudang.hapusBarang(id)
                } else {
                    println("ID barang tidak ada")
                }
            }
            5 -> {
                println("Keluar dari program")
                break
            }
            else -> println("Menu tidak tersedia")
        }
    }
}