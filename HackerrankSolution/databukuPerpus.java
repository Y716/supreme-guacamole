package HackerrankSolution;

import java.util.Scanner;

public class databukuPerpus {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int jmlPerintah = in.nextInt();
        BST pohonPencarian = new BST();
        for (int i = 0; i < jmlPerintah; i++) {
            String perintah = in.next();
            if(perintah.equalsIgnoreCase("Tambah")){
                in.next();
                System.out.println("Masukkan tahun: ");
                int tahun = in.nextInt();
                System.out.println("Masukkan judul: ");
                in.nextLine();
                String judul = in.nextLine();
                System.out.println("Masukkan penulis: ");
                String penulis = in.nextLine();
                pohonPencarian.add(tahun, judul, penulis);
                System.out.println("Data berhasil ditambahkan");
            }else if(perintah.equalsIgnoreCase("Hapus")){
                in.next();
                System.out.println("Masukkan tahun buku yang ingin dihapus:");
                int tahun = in.nextInt();
                pohonPencarian.delete(tahun);

            }else if(perintah.equalsIgnoreCase("Cari")){
                in.next();
                System.out.println("1. Cari Buku Paling Lama\n2. Cari Buku Paling Baru\n3. Cari Buku Lain\nMasukkan pilihan Anda:");
                int pilihan = in.nextInt();
                switch(pilihan){
                    case 1:
                        pohonPencarian.cariPalingLama(pohonPencarian.root);
                        break;
                    case 2:
                        pohonPencarian.cariPalingBaru(pohonPencarian.root);
                        break;
                    case 3:
                        System.out.println("Masukkan tahun buku yang ingin dicari:");    
                        int tahun = in.nextInt();
                        pohonPencarian.cariTahun(pohonPencarian.root, tahun);
                        break;
                }
            }else if(perintah.equalsIgnoreCase("tampilkan")){
                in.next();
                if(pohonPencarian.root == null){
                    System.out.println("Tidak ada data yang ditemukan");
                }else{
                    pohonPencarian.preorder(pohonPencarian.root);
                }
            }
        }
    in.close();
    }
}

class NodeBST {
    int tahun;
    String judul, penulis;
    NodeBST left, right;

    public NodeBST(int tahun, String judul, String penulis) {
        this.tahun = tahun;
        this.judul = judul;
        this.penulis = penulis;
        left = right = null;
    }
}

class BST {
    NodeBST root;

    public void add(int tahun, String judul, String penulis) {
        root = add(root, tahun, judul, penulis);
    }

    public NodeBST add(NodeBST current, int tahun, String judul, String penulis) {
        NodeBST temp = current;
        if (temp == null) {
            temp = new NodeBST(tahun, judul, penulis);
        }
        else if (tahun < current.tahun) {
            temp.left = add(current.left, tahun, judul, penulis);
        }
        else if (tahun > current.tahun) {
            temp.right = add(current.right, tahun, judul, penulis);
        }
        return temp;
    }

    public void cariTahun(NodeBST current, int tahun){
        boolean tanda = true;
        while(true){
            if(tahun < current.tahun){
                if(current.left == null){
                    tanda = false;
                    break;
                }
                current = current.left;
            }else if(tahun > current.tahun){
                if(current.left == null){
                    tanda = false;
                    break;
                }
                current = current.right;
            }else if(tahun == current.tahun){
                break;
            }
        }

        if(tanda){
            System.out.println(current.tahun + " - " + current.judul + " - " + current.penulis);
        }else{
            System.out.println("Buku tidak ada");
        }

        
    }

    public void delete(int tahun) {
		root = delete(root, tahun);
        System.out.println("Data berhasil dihapus");
	}
	
	public NodeBST delete(NodeBST current, int tahun) {
		if (current == null) {
			return null;
		}
		if (tahun < current.tahun) {
			current.left = delete(current.left, tahun);
			return current;
		}
		else if (tahun > current.tahun) {
			current.right = delete(current.right, tahun);
			return current;
		}
		else {
			if (current.left == null && current.right == null) {
				return null;
			}
			if (current.right == null) {
				return current.left;
			}
			if (current.left == null) {
				return current.right;
			}
			int smallestValue = findSmallestValue(current.right);
			current.tahun = smallestValue;
			current.right = delete(current.right, smallestValue);
			return current;
		}
	}

    public int findSmallestValue(NodeBST root) {
		if (root.left == null) {
			return root.tahun;
		}
		else {
			return findSmallestValue(root.left);
		}
	}

    public void cariPalingBaru(NodeBST current) {
        current = root;
		if (root.right == null) {
			System.out.println(root.tahun + " - " + root.judul + " - " + root.penulis);
		}
		else {
			while(true){
                if(current.right != null){
                    current = current.right;
                }else{
                    System.out.println(current.tahun + " - " + current.judul + " - " + current.penulis);
                    break;
                }
        }
	}
}
    public void cariPalingLama(NodeBST current) {
        current = root;
		if (root.left == null) {
			System.out.println(root.tahun + " - " + root.judul + " - " + root.penulis);
		}
		else {
            while(true){
                if(current.left != null){
                    current = current.left;
                }else{
                    System.out.println(current.tahun + " - " + current.judul + " - " + current.penulis);
                    break;
                }
            }
        }
	}

    public int findBiggestValue(NodeBST root) {
		if (root.right == null) {
			return root.tahun;
		}
		else {
			return findBiggestValue(root.right);
		}
	}

    public void preorder(NodeBST current) {
        System.out.println(current.tahun + " - " + current.judul + " - " + current.penulis);
        if (current.left != null) {
            preorder(current.left);
        }
        if (current.right != null) {
            preorder(current.right);
        }
    }

}

