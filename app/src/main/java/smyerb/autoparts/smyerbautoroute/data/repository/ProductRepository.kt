package smyerb.autoparts.smyerbautoroute.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import smyerb.autoparts.smyerbautoroute.data.model.Product
import smyerb.autoparts.smyerbautoroute.data.model.ProductCategory

class ProductRepository {
    private val products = listOf(
        Product(
            1,
            "Ceramic Brake Pad Set",
            "Low-dust front axle pads with consistent stopping power, chamfered edges and anti-noise shims for confident everyday driving.",
            ProductCategory.BRAKES,
            64.90,
            "https://images.unsplash.com/photo-1486262715619-67b85e0b08d3?w=1200",
        ),
        Product(
            2, "Ventilated Brake Disc", "Precision-balanced ventilated disc for stable braking temperatures.",
            ProductCategory.BRAKES, 78.50, "https://images.unsplash.com/photo-1511919884226-fd3cad34687c?w=1200",
        ),
        Product(
            3, "Premium Engine Oil 5W-30", "Fully synthetic five-litre oil for modern petrol and diesel engines.",
            ProductCategory.ENGINE, 42.95, "https://images.unsplash.com/photo-1632823471565-1ecdf5c6d7f1?w=1200",
        ),
        Product(
            4, "High-Flow Air Filter", "Washable performance filter that supports smooth airflow.",
            ProductCategory.ENGINE, 31.40, "https://images.unsplash.com/photo-1625047509168-a7026f36de04?w=1200",
        ),
        Product(
            5, "AGM Start-Stop Battery", "Maintenance-free 70Ah AGM battery with strong cycling durability.",
            ProductCategory.ELECTRICAL, 149.00, "https://images.unsplash.com/photo-1609521263047-f8f205293f24?w=1200",
        ),
        Product(
            6, "LED Headlight Pair", "Road-focused LED bulbs with crisp white illumination.",
            ProductCategory.ELECTRICAL, 54.75, "https://images.unsplash.com/photo-1503376780353-7e6692767b70?w=1200",
        ),
        Product(
            7, "Microfibre Detailing Kit", "Paint-safe cloths, wash mitt and drying towel.",
            ProductCategory.CARE, 24.99, "https://images.unsplash.com/photo-1607860108855-64acf2078ed9?w=1200",
        ),
        Product(
            8, "Ceramic Quick Detailer", "Hydrophobic spray sealant that boosts gloss.",
            ProductCategory.CARE, 18.60, "https://images.unsplash.com/photo-1520340356584-f9917d1eea6f?w=1200",
        ),
        Product(
            9, "All-Weather Floor Mats", "Deep-channel rubber mats that contain rain and grit.",
            ProductCategory.ACCESSORIES, 45.00, "https://images.unsplash.com/photo-1549317661-bd32c8ce0db2?w=1200",
        ),
        Product(
            10, "Magnetic Phone Mount", "Compact adjustable dashboard mount with a strong hold.",
            ProductCategory.ACCESSORIES, 19.95, "https://images.unsplash.com/photo-1517524008697-84bbe3c3fd98?w=1200",
        ),
        Product(
            11, "Emergency Roadside Kit", "Warning triangle, vest, torch, gloves and booster cables.",
            ProductCategory.ACCESSORIES, 39.50, "https://images.unsplash.com/photo-1487754180451-c456f719a1fc?w=1200",
        ),
        Product(
            12, "Iridium Spark Plug Set", "Long-life plugs for precise ignition and smooth idle.",
            ProductCategory.ENGINE, 36.80, "https://images.unsplash.com/photo-1619642751034-765dfdf7c58e?w=1200",
        ),
    )

    fun observeById(id: Int): Flow<Product?> = flowOf(products.find { it.id == id })

    fun getById(id: Int): Product? = products.find { it.id == id }

    fun observeAll(): Flow<List<Product>> = flowOf(products)
}
