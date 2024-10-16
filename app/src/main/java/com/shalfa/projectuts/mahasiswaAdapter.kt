package com.shalfa.projectuts

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MahasiswaAdapter(private val mahasiswaList: List<identitasMahasiswa>) : RecyclerView.Adapter<MahasiswaAdapter.MahasiswaViewHolder>() {

    private val attendanceStatusList = MutableList(mahasiswaList.size) { "" }
    private var notifyButtonStateChanged: (() -> Unit)? = null

    class MahasiswaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvNamaMahasiswa: TextView = itemView.findViewById(R.id.tvNamaMahasiswa)
        val tvNimMahasiswa: TextView = itemView.findViewById(R.id.tvNimMahasiswa)
        val tvNoAbsen: TextView = itemView.findViewById(R.id.tvNoAbsenMahasiswa)
        val tvAttendanceStatus: TextView = itemView.findViewById(R.id.tvAttendanceStatus)
        val buttonHadir: Button = itemView.findViewById(R.id.button1)
        val buttonSakit: Button = itemView.findViewById(R.id.button2)
        val buttonIjin: Button = itemView.findViewById(R.id.button3)
        val buttonAlpha: Button = itemView.findViewById(R.id.button4)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MahasiswaViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.mahasiswa_list, parent, false)
        return MahasiswaViewHolder(layout)
    }

    override fun getItemCount(): Int {
        return mahasiswaList.size
    }

    override fun onBindViewHolder(holder: MahasiswaViewHolder, position: Int) {
        val mahasiswa = mahasiswaList[position]

        holder.tvNamaMahasiswa.text = mahasiswa.namaMahasiswa
        holder.tvNimMahasiswa.text = mahasiswa.nimMahasiswa
        holder.tvNoAbsen.text = mahasiswa.noAbsen

        // Reset the buttons and status text based on the current attendance status
        when (attendanceStatusList[position]) {
            "Hadir" -> holder.tvAttendanceStatus.text = "Hadir"
            "Sakit" -> holder.tvAttendanceStatus.text = "Sakit"
            "Ijin" -> holder.tvAttendanceStatus.text = "Ijin"
            "Alpha" -> holder.tvAttendanceStatus.text = "Alpha"
            else -> holder.tvAttendanceStatus.text = ""
        }

        holder.buttonHadir.setOnClickListener {
            holder.tvAttendanceStatus.text = "Hadir"
            attendanceStatusList[position] = "Hadir"
            notifyButtonStateChanged?.invoke()
        }
        holder.buttonSakit.setOnClickListener {
            holder.tvAttendanceStatus.text = "Sakit"
            attendanceStatusList[position] = "Sakit"
            notifyButtonStateChanged?.invoke()
        }
        holder.buttonIjin.setOnClickListener {
            holder.tvAttendanceStatus.text = "Ijin"
            attendanceStatusList[position] = "Ijin"
            notifyButtonStateChanged?.invoke()
        }
        holder.buttonAlpha.setOnClickListener {
            holder.tvAttendanceStatus.text = "Alpha"
            attendanceStatusList[position] = "Alpha"
            notifyButtonStateChanged?.invoke()
        }
    }

    fun getAttendanceStatusList(): List<String> {
        return attendanceStatusList
    }

    fun allPresencesMarked(): Boolean {
        return attendanceStatusList.all { it.isNotEmpty() }
    }

    fun setNotifyButtonStateChanged(callback: () -> Unit) {
        notifyButtonStateChanged = callback
    }
}
